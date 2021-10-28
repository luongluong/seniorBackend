package com.example.seniorBackEnd.dao;
import com.example.seniorBackEnd.entity.processData;

import java.sql.SQLException;
import java.util.List;


public interface processDao {
    List<processData> listOfProcess();
    void insertProcess(processData data) throws SQLException;
    void updateProcess(int id);
    void deleteProcess(int data);

}
