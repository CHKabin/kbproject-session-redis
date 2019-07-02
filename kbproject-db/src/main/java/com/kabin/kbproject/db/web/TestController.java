package com.kabin.kbproject.db.web;

import com.kabin.kbproject.db.entity.SysUserEntity;
import com.kabin.kbproject.db.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/6/23.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private SysUserService userService;

    @GetMapping("hello")
    public String hello() {
        SysUserEntity user = userService.getByUsername("admin");
        System.out.println(user.getId());
        return "hello, world";
    }
}
