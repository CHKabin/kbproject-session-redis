package com.kabin.kbproject.main.web;

import com.kabin.kbproject.db.entity.SysUserEntity;
import com.kabin.kbproject.db.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/6/23.
 */
@RestController
@RequestMapping("/test")
public class TestController2 {

    private static Logger LOGGER = LoggerFactory.getLogger(TestController2.class);

    @Autowired
    SysUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("hello2")
    public String hello() {
        return "hello, world2";
    }

    @GetMapping("getUser")
    public String getUser() {
//        SysUserEntity user = userService.getUserById(2);
        String result = "查询成功，testss1w15";
//        System.out.println(result);
//        System.out.println(user);
        long userId = 2;
        SysUserEntity userJpa = userService.getUserByJpaId(userId);
        System.out.println("userJpa:"+ userJpa.getUsername());
        return result;
    }

    @GetMapping("addUser")
    public String addUser() {
        SysUserEntity user = new SysUserEntity();
        user.setUsername("test");
        userService.saveUser(user);
        System.out.println("插入成功:");
        return "插入成功";
    }

    @GetMapping("testLog")
    public String testLog() {
        System.out.println("test");
        LOGGER.error("测试日志:error");
        return "测试日志:error";
    }

    @GetMapping("testRedis")
    public String testRedis() {
        LOGGER.error("测试日志:error");
        redisTemplate.opsForValue().set("test","abc");
        String result = redisTemplate.opsForValue().get("test").toString();
        return result;
    }
}