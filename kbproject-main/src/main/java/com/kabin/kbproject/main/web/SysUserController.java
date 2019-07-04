package com.kabin.kbproject.main.web;

import com.kabin.kbproject.db.service.SysUserService;
import com.kabin.kbproject.main.util.PasswordEncry;
import com.kabin.kbproject.db.entity.SysUserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ckb
 * @date: 2019/6/25
 * @description:
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequiresPermissions("user:create")
    @PostMapping("/addUser")
    public Object addUser(SysUserEntity user) {
        SysUserEntity userEntity = PasswordEncry.encrypt(user);
        byte lock = 0;
        userEntity.setLocked(lock);
        sysUserService.saveUser(userEntity);
        return userEntity;
    }

    @RequiresPermissions("user:create")
    @GetMapping("/showUser")
    public String showUser() {
        return "test";
    }
}
