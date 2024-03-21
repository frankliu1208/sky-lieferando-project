package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "general interface")
@Slf4j
public class CommonController {

    // the argument "file" need to be aligned with the "key" name in the request body from the frontend request
    @PostMapping("/upload")
    @ApiOperation("file upload")
    public Result<String> upload(MultipartFile file) {
        log.info("file: {}", file);
        return null;
    }







}
