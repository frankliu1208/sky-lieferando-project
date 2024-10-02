//package com.sky.controller.admin;
//
//import com.sky.constant.StatusConstant;
//import com.sky.dto.DishDTO;
//import com.sky.dto.DishPageQueryDTO;
//import com.sky.entity.Dish;
//import com.sky.result.PageResult;
//import com.sky.result.Result;
//import com.sky.service.DishService;
//import com.sky.vo.DishVO;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin/dish")
//@Api(tags = "dish related controller,  this is admin side,  customer side controller is not yet created. ")
//@Slf4j
//public class DishController {
//
//    @Autowired
//    private DishService dishService;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @PostMapping
//    @ApiOperation("add new dishes")
//    public Result save(@RequestBody DishDTO dishDTO) {
//        log.info("the dish is: {}",dishDTO);
//        dishService.saveWithFlavor( dishDTO);
//        return Result.success();
//    }
//
//    // the frontend will data to backend through Query (http://...? key= value,  so this is not json type)
//    @GetMapping("/page")
//    @ApiOperation("dish pagination search ")
//    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
//        log.info("search by pagination: {}", dishPageQueryDTO);
//        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
//        return Result.success(pageResult);
//
//    }
//
//    @DeleteMapping
//    @ApiOperation("batch deleting")
//    public Result delete (@RequestParam List<Long> ids) {
//        dishService.deleteBatch(ids);
//        return Result.success();
//    }
//
//    @GetMapping("/{id}")
//    @ApiOperation("search dish according to ID")
//    public Result<DishVO> getById( @PathVariable Long id ) {
//        DishVO dishVO = dishService.getByIdWithFlavor(id);
//        return Result.success(dishVO);
//    }
//
//
//    @PutMapping
//    @ApiOperation("modify the dishes")
//    public Result update(@RequestBody DishDTO dishDTO) {
//        dishService.updateWithFlavor(dishDTO);
//        return Result.success();
//    }
//
//
//    @GetMapping("/list")
//    public Result<List<DishVO>> list(Long categoryId) {
//
//        String key = "dish_" + categoryId;
//        List<DishVO> list = (List<DishVO>) redisTemplate.opsForValue().get(key);
//        if (list != null && list.size() >0) {
//            return Result.success(list);
//        }
//
//
//        Dish dish = new Dish();
//        dish.setCategoryId(categoryId);
//        dish.setStatus(StatusConstant.ENABLE);
//
//        list = dishService.listWithFlavor(dish);
//
//        redisTemplate.opsForValue().set(key, list);
//
//
//        return Result.success(list);
//    }
//
//
//
//}
