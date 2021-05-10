package org.framework;

import org.idl.ILogin;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public class LogIn extends ILogin {
    @Override
    public boolean login(String user, String pass) {
        System.out.println("正在登录...");
        if (user.equals("aaa")) {
            if (pass.equals("bbb")) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("密码错误");
                return false;
            }
        } else {
            System.out.println("用户名不存在");
            return false;
        }
    }
}
