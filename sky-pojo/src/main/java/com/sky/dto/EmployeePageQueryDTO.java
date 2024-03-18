package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

// pagination search feature:  below 3 parameters are values that frontend need to send to backend when making POST or GET request
// Returned value from backend will be encapsulated into Result<PageResult> object
@Data
public class EmployeePageQueryDTO implements Serializable {

    //员工姓名
    private String name;

    //页码  page number
    private int page;

    //每页显示记录数  items per page
    private int pageSize;

}
