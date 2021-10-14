package com.example.seniorBackEnd.dao;

import com.example.seniorBackEnd.entity.processData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class processDaoImpl implements processDao {

    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    String sql = "SELECT * FROM processData";
    @Override
    public List<processData> listOfProcess() {
        List<processData> processDataList = jdbcTemplateObject.query(sql,
                BeanPropertyRowMapper.newInstance(processData.class));
        return processDataList;
    }

    @Override
    public void insertProcess(processData data) {
        SimpleJdbcInsert insertProcessData = new SimpleJdbcInsert(jdbcTemplateObject);
        insertProcessData.withTableName("processData").usingColumns("name","description");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(data);

        insertProcessData.execute(param);

    }

    @Override
    public void readProcess(processData data) {

    }

    @Override
    public void updateProcess(processData data) {

    }

    @Override
    public void deleteProcess(processData data) {

    }
}
