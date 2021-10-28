package com.example.seniorBackEnd.service;
import com.example.seniorBackEnd.dao.processDao;
import com.example.seniorBackEnd.entity.processData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@Service

public class processServiceImpl implements processService {
//need the DAO before this one can be implemented
    @Resource
    processDao processDaoObj;

    @Override
    public List<processData> listOfProcess() {
        return processDaoObj.listOfProcess();
    }



    @Override
    public void insertUserData(processData data) throws SQLException {
        processDaoObj.insertProcess(data);
    }

    @Override
    public void updateUserData(int data) {


    }

    @Override
    public void deleteUserData(int id) {
        processDaoObj.deleteProcess(id);

    }
}
