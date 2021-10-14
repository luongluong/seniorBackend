package com.example.seniorBackEnd.service;

import com.example.seniorBackEnd.entity.processData;

import java.util.List;

public interface processService {
    List<processData> listOfProcess();
    void insertUserData(processData user);
    void updateUserData(processData user);
    void deleteUserData(processData user);
}
