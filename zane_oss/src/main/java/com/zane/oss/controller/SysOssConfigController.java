package com.zane.oss.controller;

import com.zane.oss.OssFactory;
import com.zane.oss.domain.CloudStorageConfig;
import com.zane.oss.service.ISysOssConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author Administrator
 * @create 2018-01-04 17:03
 * @desc 管理对象存储配置控制层
 **/
@RestController
@RequestMapping("/sys/oss/")
public class SysOssConfigController {
    @Autowired
    private ISysOssConfigService iSysOssConfigService;

//    @RequestMapping(value = { "index.do" }, method = { RequestMethod.GET, RequestMethod.POST })
    @RequestMapping(value="index")
    @ResponseBody
    public Object index( ) {

        File file = new File("C:\\Users\\Administrator\\Desktop\\timg.jpg");
//        byte[] byt = null;
        InputStream input = null;
        try {
            input = new FileInputStream(file);
//            byt = new byte[input.available()];
//            input.read(byt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(input==null);
        String url = OssFactory.build().upload(input,"/image",file.getName());
        CloudStorageConfig bean = iSysOssConfigService.getConfig();
        return url;
    }
}
