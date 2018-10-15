package com.example.demo4.dao;

import com.example.demo4.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysLogDaoImpl implements SysLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(user_name,operation,c_time) ");
        sql.append("values(:username,:operation,:cTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
    }


}
