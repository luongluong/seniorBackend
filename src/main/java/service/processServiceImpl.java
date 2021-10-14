package service;
import dao.processDao;
import dao.processDaoImpl;
import entity.processData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public void insertUserData(processData data) {
        processDaoObj.insertProcess(data);
    }

    @Override
    public void updateUserData(processData data) {

    }

    @Override
    public void deleteUserData(processData data) {

    }
}
