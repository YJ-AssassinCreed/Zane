package com.zane.oss.dao.impl;

import com.zane.base.util.QvoConditionUtil;
import com.zane.oss.dao.ISysConfigDao;
import com.zane.oss.domain.CloudStorageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @create 2018-01-08 15:55
 * @desc
 **/
@Repository
public class SysConfigDaoImpl implements ISysConfigDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public CloudStorageConfig getConfigObject() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sys_config_oss");
        List<CloudStorageConfig> list = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<CloudStorageConfig>(CloudStorageConfig.class));
        return QvoConditionUtil.checkList(list)?list.get(0):null;
    }
}
