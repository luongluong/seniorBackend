package com.example.seniorBackEnd.controller;

import com.example.seniorBackEnd.entity.processData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.seniorBackEnd.service.processService;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin
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
    public void insertProcessData(@RequestBody processData data) throws SQLException {
        processServiceObj.insertUserData(data);
    }

    @RequestMapping("/delete/{id}")
    public void deleteProcessData(@PathVariable(name = "id") int id) {
        processServiceObj.deleteUserData(id);
       // return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable (name = "id") int id) /*@ModelAttribute("processData") processData data)*/ {
        processServiceObj.updateUserData(id);

        //return "redirect:/";
    }


}
