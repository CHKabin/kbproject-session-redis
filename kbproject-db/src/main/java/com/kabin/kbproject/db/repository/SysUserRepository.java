package com.kabin.kbproject.db.repository;

import com.kabin.kbproject.db.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2019/6/24.
 */
public interface SysUserRepository extends JpaRepository<SysUserEntity,Long> {
    SysUserEntity getByUsername(String name);

    SysUserEntity getById(long id);
}
