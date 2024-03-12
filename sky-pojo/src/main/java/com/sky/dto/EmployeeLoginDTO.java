package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "员工登录时传递的数据模型 transferred data model when employee logs in")
public class EmployeeLoginDTO implements Serializable {

    @ApiModelProperty("this is user name property")
    private String username;

    @ApiModelProperty("this is password property")
    private String password;

}
