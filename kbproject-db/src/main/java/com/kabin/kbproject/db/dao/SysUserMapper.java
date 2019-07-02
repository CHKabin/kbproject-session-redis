package com.kabin.kbproject.db.dao;

import com.kabin.kbproject.db.entity.SysUserEntity;

/**
 * Created by Administrator on 2019/6/24.
 */
public interface SysUserMapper {
    SysUserEntity getUserById(int id);
}
