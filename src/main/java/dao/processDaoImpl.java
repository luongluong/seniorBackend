package dao;

import entity.processData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
