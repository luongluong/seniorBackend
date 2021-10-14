package dao;
import entity.processData;

import java.util.List;


public interface processDao {
    List<processData> listOfProcess();
    void insertProcess(processData data);
    void readProcess(processData data);
    void updateProcess(processData data);
    void deleteProcess(processData data);

}
