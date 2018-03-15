package com.zane.oss.constant;

/**
 * @author Administrator
 * @create 2018-01-08 16:50
 * @desc 云存储常量类
 **/
public class OssConstant {
    /**
     * 云服务商
     */
    public enum CloudService{
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        private CloudService(int value){
            this.value = value;
        }
        public int getValue(){
            return  value;
        }

    }


}
