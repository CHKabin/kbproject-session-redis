package com.kabin.kbproject.db.service;

import com.kabin.kbproject.db.entity.SysUserEntity;

import java.util.List;

/**
 * Created by Administrator on 2019/6/24.
 */
public interface SysUserService {
    SysUserEntity getUserById(int id);

    SysUserEntity getUserByJpaId(long id);

    void saveUser(SysUserEntity entity);

    SysUserEntity getByUsername(String username);

    List<String> getRolesByUsername(String username);

    List<String> getPermissionsByUserName(String username);
}
