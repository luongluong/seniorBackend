package com.example.seniorBackEnd.entity;

import javax.persistence.Id;

//design data or process data
public class processData {
    @Id
    private int id;

    private String name;
    private String description;
    private String status;  //status of the record (active, inactive, deleted)
    private byte[] design; //store Json

    ///dont need
    public processData(){}
    public processData(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int    id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getDesign() {
        return design;
    }

    public void setDesign(byte[] design) {
        this.design = design;
    }
}
