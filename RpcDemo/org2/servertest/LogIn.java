package org2.servertest;

import org2.idl.AbLogIn;

/**
 * Author:WangQian
 * Date: 18-6-13 下午4:00
 */
public class LogIn extends AbLogIn {
    @Override
    public boolean logIn(String counter, String pass) {

        System.out.println("执行LogIn.logIn");
        if(counter.equals("aaa") && pass.equals("bbb")){
            return true;
        }
        return false;
    }

    @Override
    public String logIn1(String counter, String pass, String date) {
        System.out.println("执行LogIn.logIn1");
        if(counter.equals("aaa") && pass.equals("bbb")){
            return "登录成功 日期    "+date;
        }
        return "登录失败";
    }
}
