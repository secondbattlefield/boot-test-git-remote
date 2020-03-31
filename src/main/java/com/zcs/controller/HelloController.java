package com.zcs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zcs
 * @data: 2020/3/30
 * @description:
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "hello git";
    }

    //开发人员写了一句话
}
