package com.zane.oss.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

/**
 * @author Administrator
 * @create 2018-01-05 10:07
 * @desc 云存储配置
 **/
@Data
@ToString
public class CloudStorageConfig {
    private Long	id;
    private Integer type;
    /** 七牛绑定的域名 **/
    public String qiniuDomain;
    /** 七牛路径前缀 */
    public String qiniuPrefix;
    /** 七牛ACCESS_KEY **/
    public String qiniuAccessKey;
    /** 七牛SECRET_KEY **/
    public String qiniuSecretKey;
    /** 七牛存储空间名 **/
    public String qiniuBucketName;
    /** 阿里云绑定的域名 */
    private String aliyunDomain;
    /** 阿里云路径前缀 */
    private String aliyunPrefix;
    /** 阿里云EndPoint */
    private String aliyunEndPoint;
    /** 阿里云AccessKeyId */
    private String aliyunAccessKeyId;
    /** 阿里云AccessKeySecret */
    private String aliyunAccessKeySecret;
    /** 阿里云BucketName */
    private String aliyunBucketName;
    /** 腾讯云绑定的域名 */
    private String qcloudDomain;
    /** 腾讯云路径前缀 */
    private String qcloudPrefix;
    /** 腾讯云AppId */
    private Integer qcloudAppId;
    /** 腾讯云SecretId */
    private String qcloudSecretId;
    /** 腾讯云SecretKey */
    private String qcloudSecretKey;
    /** 腾讯云BucketName */
    private String qcloudBucketName;
    /** 腾讯云COS所属地区 */
    private String qcloudRegion;


}
