package com.example.demo.controller;


import com.example.demo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @RequestMapping()
    public JsonResult test(){
        return JsonResult.ok("测试");
    }
}
