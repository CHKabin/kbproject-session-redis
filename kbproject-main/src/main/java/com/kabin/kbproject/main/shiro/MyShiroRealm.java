package com.kabin.kbproject.main.shiro;

import com.alibaba.fastjson.JSON;
import com.kabin.kbproject.db.entity.SysUserEntity;
import com.kabin.kbproject.db.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ckb
 * @date: 2019/6/24
 * @description:
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        Object obj = getAvailablePrincipal(principals);
        SysUserEntity user = new SysUserEntity();
        if(obj instanceof SysUserEntity) {
            user = (SysUserEntity) obj;
        } else {
            user = JSON.parseObject(JSON.toJSON(obj).toString(), SysUserEntity.class);
        }

        List<String> roleList= sysUserService.getRolesByUsername(user.getUsername());
        List<String> permissionList= sysUserService.getPermissionsByUserName(user.getUsername());
        Set<String> role = new HashSet<>();
        Set<String> permission = new HashSet<>();

        role.addAll(roleList);
        permission.addAll(permissionList);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(role);
        authorizationInfo.setStringPermissions(permission);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        //通过username从数据库中查找 User对象
        SysUserEntity user = sysUserService.getByUsername(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
