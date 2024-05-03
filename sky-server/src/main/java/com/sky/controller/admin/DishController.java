package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "dish related controller")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("add new dishes")
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("the dish is: {}",dishDTO);
        dishService.saveWithFlavor( dishDTO);
        return Result.success();
    }

    // the frontend will data to backend through Query (http://...? key= value,  so this is not json type)
    @GetMapping("/page")
    @ApiOperation("dish pagination search ")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("search by pagination: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);

    }

}
