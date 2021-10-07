package dao;
import entity.processData;


public interface processDao {
      Object listOfProcess();
    void insertProcess(processData data);
    void readProcess(processData data);
    void updateProcess(processData data);
    void deleteProcess(processData data);

}
