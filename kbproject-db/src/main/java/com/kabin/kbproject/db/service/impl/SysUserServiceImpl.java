package com.kabin.kbproject.db.service.impl;

import com.kabin.kbproject.db.dao.SysPermissionMapper;
import com.kabin.kbproject.db.dao.SysRoleMapper;
import com.kabin.kbproject.db.dao.SysUserMapper;
import com.kabin.kbproject.db.entity.SysUserEntity;
import com.kabin.kbproject.db.repository.SysUserRepository;
import com.kabin.kbproject.db.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/24.
 */
@Service("userService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUserEntity getUserById(int id) {
        return sysUserMapper.getUserById(id);
    }


    @Override
    public SysUserEntity getUserByJpaId(long id) {
        SysUserEntity user = sysUserRepository.getById(id);
        System.out.println("service:"+user.getUsername());
        return sysUserRepository.getByUsername("admin");
    }

    @Override
    public void saveUser(SysUserEntity entity) {
        sysUserRepository.save(entity);
    }

    @Override
    public SysUserEntity getByUsername(String username) {
        return sysUserRepository.getByUsername(username);
    }

    @Override
    public List<String> getRolesByUsername(String username) {
        return sysRoleMapper.getRolesByUsername(username);
    }

    @Override
    public List<String> getPermissionsByUserName(String username) {
        return sysPermissionMapper.getPermissionsByUsername(username);
    }
}
