package com.kabin.kbproject.main.util;

import com.kabin.kbproject.db.entity.SysUserEntity;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordEncry {

    //随机数生成器
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    //指定散列算法为md5
    private static String algorithmName = "MD5";
    //散列迭代次数
    private static final int hashIterations = 2;

    /**
     * 生成随机盐值对密码进行加密
     * @param userLogin  登录识别串（用户名）
     * @return
     */
    public static SysUserEntity encrypt(SysUserEntity userLogin) {
        userLogin.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName,userLogin.getPassword(),
            ByteSource.Util.bytes(userLogin.getSalt()), hashIterations).toHex();

        userLogin.setPassword(newPassword);
        return userLogin;

    }
}