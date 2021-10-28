package com.example.seniorBackEnd.service;

import com.example.seniorBackEnd.entity.processData;

import java.sql.SQLException;
import java.util.List;

public interface processService {
    List<processData> listOfProcess();
    void insertUserData(processData user) throws SQLException;
    void updateUserData(int user);
    void deleteUserData(int user);
}
