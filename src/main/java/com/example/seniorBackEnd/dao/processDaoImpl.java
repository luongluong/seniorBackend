package com.example.seniorBackEnd.dao;

import com.example.seniorBackEnd.entity.processData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class processDaoImpl implements processDao {

    @Autowired
    private JdbcTemplate jdbcTemplateObject;
    //String sqlInsert = "INSERT INTO processData (name, description, status, design) VALUES (?, ?, ?, ?)";
    String sql = "SELECT * FROM processData";

    @Override
    public List<processData> listOfProcess() {
        List<processData> processDataList = jdbcTemplateObject.query(sql,
                BeanPropertyRowMapper.newInstance(processData.class));
        return processDataList;
    }

    @Override
    public void insertProcess(processData data) throws SQLException {
        //Blob blobData = jdbcTemplateObject.createBlob();;
        // blobData.setBytes(1, data.getDesign());
        //A SimpleJdbcInsert is a multi-threaded,
        // reusable object providing easy insert capabilities for a table.
        // It provides meta-data processing to simplify the code needed
        // to construct a basic insert statement.
        // All you need to provide
        // is the name of the table and a Map containing the column names and the column values.

     /*   SimpleJdbcInsert insertProcessData = new SimpleJdbcInsert(jdbcTemplateObject);
        insertProcessData.withTableName("processData").usingColumns("name","description","status","design");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(data);
        insertProcessData.execute(param);  */

        //SqlParameterSource implementation that obtains parameter values
        // from bean properties of a given JavaBean object.
        // The names of the bean properties have to match the parameter names.
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplateObject);
        insertActor.withTableName("processData");
        Map<String, Object> params = new HashMap<>();
        params.put("name", data.getName());
        params.put("description", data.getDescription());
        params.put("status", data.getStatus());

        String value = data.getTest();
        byte[] buff = value.getBytes();
        Blob content_xml = new SerialBlob(buff);
        params.put("design", content_xml);
        insertActor.execute(params);

    }
 /*   public processData store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        processData FileDB = new processData(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(FileDB);
    } */


    @Override
    public void updateProcess(int id)
    {

        String sql = "UPDATE  processData Set name = name, description = description, status = status WHERE id= ?";
        BeanPropertySqlParameterSource update = new BeanPropertySqlParameterSource(id);


        //NamedParameterJdbcTemplate =
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplateObject);
        template.update(sql,update);
    }


    @Override
    public void deleteProcess(int id) {
        String sql = "DELETE FROM processData WHERE id = ?";
        jdbcTemplateObject.update(sql, id);
    }
}