package com.kabin.kbproject.db.dao;


import java.util.List;

/**
 * @author: ckb
 * @date: 2019/6/24
 * @description:
 */
public interface SysPermissionMapper {

    List<String> getPermissionsByUsername(String userName);

}
