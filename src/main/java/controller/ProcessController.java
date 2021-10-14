package controller;
import  javax.annotation.Resource;

import entity.processData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.processService;
import java.util.List;

@Controller
@RequestMapping("/processData")
public class ProcessController {
    //modify controller
    @Resource
    processService processServiceObj;

    @GetMapping(value = "/processList")
    public List<processData> getProcessData(){
        return processServiceObj.listOfProcess();
    }

    @PostMapping(value = "/insertProcess")
    public void insertProcessData(@RequestBody processData data) {
        processServiceObj.insertUserData(data);
    }



}
