package com.zane.oss;

import com.zane.base.util.DateUtil;
import com.zane.oss.domain.CloudStorageConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author Administrator
 * @create 2018-01-05 9:45
 * @desc 云存储服务抽象类
 **/
public abstract class AbstractCloudStorageService {
    /** 云存储配置信息 */
    CloudStorageConfig config;

    public String getFilePath(String path,String fileName){
        String uuid = (DateUtil.getFormateDate("yyyyMMddHHmmss")+ UUID.randomUUID().toString()).replaceAll("-", "");
        String filePath = (path+"/"+uuid+fileName).replaceAll("//","/");
        return filePath;
    }

    /**
     * 文件上传
     * @param inputStream 字节流
     * @param path 文件路径
     * @return 返回包含http地址
     */
    public abstract String upload(InputStream inputStream,String path,String fileName);

}
