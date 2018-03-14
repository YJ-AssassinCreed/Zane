package com.zane.oss;

import com.zane.base.util.SpringContextUtil;
import com.zane.oss.constant.OssConstant;
import com.zane.oss.domain.CloudStorageConfig;
import com.zane.oss.service.ISysOssConfigService;

/**
 * @author Administrator
 * @create 2018-01-08 11:35
 * @desc 对象存储工厂
 **/
public class OssFactory {

    private static ISysOssConfigService sysOssConfigService;

    static {
        OssFactory.sysOssConfigService = SpringContextUtil.getBean(ISysOssConfigService.class);
    }

    public static AbstractCloudStorageService build(){
        CloudStorageConfig config = sysOssConfigService.getConfig();
        if(config.getType()== OssConstant.CloudService.QINIU.getValue()){
            return new QiNiuCloudStorageService(config);
        }else if(config.getType()== OssConstant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }
        return null;
    }

}
