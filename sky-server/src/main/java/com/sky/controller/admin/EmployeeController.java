package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags="employee related interface")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * @param employeeLoginDTO,  data transferred from the frontend
     */
    @PostMapping("/login")
    @ApiOperation("employee log-in")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("employee log in：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();
        //  the data from backend is encapsulated into Result class
        return Result.success(employeeLoginVO);
    }


    /**
     * log out
     */
    @PostMapping("/logout")
    @ApiOperation("employee log-out")
    public Result<String> logout() {
        return Result.success();
    }


    @PostMapping
    @ApiOperation("add new employee")
    public Result save(@RequestBody  EmployeeDTO employeeDTO) {
        log.info("new employee added: {}", employeeDTO);
        employeeService.save(employeeDTO);
        return Result.success();
    }


    @GetMapping("/page")
    @ApiOperation("pagination search")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO) {
        log.info("this is pagination search, data from frontend: {}", employeePageQueryDTO);
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    // non-search operation,  we dont need the generic because backend dont need to return detailed data to frontend
    @PostMapping("/status/{status}")
    @ApiOperation("enable/disable user account")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        log.info("user account: {}, {}", status, id);
        employeeService.startOrStop(status, id);
        return Result.success();
    }


}
