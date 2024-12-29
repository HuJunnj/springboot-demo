package org.example.springboot.demos.web.entity;

import com.alibaba.excel.annotation.ExcelProperty;

public class Employee {
    public Employee(Integer id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @ExcelProperty("员工编号")
    private Integer id;

    @ExcelProperty("员工姓名")
    private String name;

    @ExcelProperty("职位")
    private String position;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

