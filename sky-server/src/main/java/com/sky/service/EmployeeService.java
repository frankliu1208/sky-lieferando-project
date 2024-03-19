package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * user log-in
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * add new employee
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    // enable/disable user account
    void startOrStop(Integer status, Long id);

    // search for employee info according to id
    Employee getById(Long id);

    // edit employee message
    void update(EmployeeDTO employeeDTO);
}
