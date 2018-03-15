package com.zane.oss;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.zane.base.util.DateUtil;
import com.zane.oss.domain.CloudStorageConfig;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.UID;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author Administrator
 * @create 2018-01-05 9:57
 * @desc 七牛云存储服务
 **/
public class QiNiuCloudStorageService extends AbstractCloudStorageService{

    private UploadManager uploadManager;
    private String token;

    public QiNiuCloudStorageService(CloudStorageConfig config){
        this.config = config;
        init();
    }

    public void init(){
        uploadManager = new UploadManager(new Configuration(Zone.autoZone()));
        Auth auth = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey());
        token = auth.uploadToken(config.getQiniuBucketName());
    }

    @Override
    public String upload(InputStream inputStream, String path,String fileName) {
        String filePath = null;
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            inputStream.read(data);
            if(StringUtils.isBlank(path)){
                path = config.getQiniuPrefix();
            }
            //七牛云存储路径不能以/开头
            String head =  "/";
            if(path.startsWith(head)){
                path = path.substring(1, path.length());
            }
            filePath = getFilePath(path,fileName);
            uploadManager.put(data,filePath,token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config.getQiniuDomain()+"/"+filePath;
    }
}
