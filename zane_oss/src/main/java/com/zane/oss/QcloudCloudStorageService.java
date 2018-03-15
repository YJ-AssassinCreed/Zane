package com.zane.oss;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;
import com.zane.oss.domain.CloudStorageConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;

/**
 * @author Administrator
 * @create 2018-01-12 15:51
 * @desc 腾讯云对象存储
 **/
public class QcloudCloudStorageService extends AbstractCloudStorageService {

    private COSClient cosclient;

    public QcloudCloudStorageService(CloudStorageConfig config){
        this.config = config;
        init();
    }
    public void init(){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(config.getQcloudSecretId(), config.getQcloudSecretKey());
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(config.getQcloudRegion()));
        // 3 生成cos客户端
         cosclient = new COSClient(cred, clientConfig);
    }


    @Override
    public String upload(InputStream inputStream, String path, String fileName) {

        if(StringUtils.isBlank(path)){
            path = config.getQcloudPrefix();
        }
        // 腾讯云必需要以"/"开头
        String head = "/";
        if(!path.startsWith(head)){
            path = head + path;
        }
        path = getFilePath(path,fileName);
        //上传腾讯云
        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            objectMetadata.setContentLength(inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService threadPool = new ThreadPoolExecutor(32, 32,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        // 传入一个threadpool, 若不传入线程池, 默认TransferManager中会生成一个单线程的线程池。
        TransferManager transferManager = new TransferManager(cosclient, threadPool);
        PutObjectRequest putObjectRequest = new PutObjectRequest(config.getQcloudBucketName(),path,inputStream,objectMetadata);
        Upload upload = transferManager.upload(putObjectRequest);
        // 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
        UploadResult uploadResult = null;
        try {
            uploadResult = upload.waitForUploadResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭 TransferManger
        transferManager.shutdownNow();
        return config.getQcloudDomain()+uploadResult.getKey();
    }
}
