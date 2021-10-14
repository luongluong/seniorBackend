package com.example.seniorBackEnd.controller;

import com.example.seniorBackEnd.entity.processData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.seniorBackEnd.service.processService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/processData")
public class ProcessController {

   // private processDao dao;
    //modify controller
   // @Resource
    @Autowired
    processService processServiceObj;

    @GetMapping( "/processList")
    public List<processData> getProcessData(){
        return processServiceObj.listOfProcess();
    }

    @PostMapping( "/insertProcess")
    public void insertProcessData(@RequestBody processData data) {
        processServiceObj.insertUserData(data);
    }



}
