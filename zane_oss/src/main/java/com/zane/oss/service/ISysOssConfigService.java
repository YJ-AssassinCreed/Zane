package com.zane.oss.service;

import com.zane.oss.domain.CloudStorageConfig;
import org.springframework.stereotype.Service;


public interface ISysOssConfigService {

     CloudStorageConfig getConfig();
}
