package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

// the property of this dto is aligned with request param from frontend
@Data
public class DishPageQueryDTO implements Serializable {

    private int page;

    private int pageSize;

    private String name;

    //分类id
    private Integer categoryId;

    //状态 0表示禁用 1表示启用
    private Integer status;

}
