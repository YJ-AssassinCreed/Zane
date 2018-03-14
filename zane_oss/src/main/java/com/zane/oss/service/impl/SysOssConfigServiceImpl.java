package com.zane.oss.service.impl;

import com.zane.oss.OssFactory;
import com.zane.oss.dao.ISysConfigDao;
import com.zane.oss.domain.CloudStorageConfig;
import com.zane.oss.service.ISysOssConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2018-01-04 17:25
 * @desc 管理对象存储配置服务实现类
 **/
@Service("ISysOssConfigService")
public class SysOssConfigServiceImpl implements ISysOssConfigService{
    @Autowired
    private ISysConfigDao iSysConfigDao;

    @Override
    public CloudStorageConfig getConfig() {
        return iSysConfigDao.getConfigObject();
    }
}
