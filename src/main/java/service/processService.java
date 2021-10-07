package service;

import entity.processData;

import java.util.List;

public interface processService {
    List<processData> findAll();
    void insertUserData(processData user);
    void updateUserData(processData user);
    void deleteUserData(processData user);
}
