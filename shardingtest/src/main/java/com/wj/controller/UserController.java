package com.wj.controller;

import com.wj.entity.UserEntity;
import com.wj.entity.UserSexEnum;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService user1Service;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users=user1Service.getUsers();
        return users;
    }
    @RequestMapping("/getUserById")
    public UserEntity getUserById(@RequestParam(value = "id") String id) {
        UserEntity user=user1Service.getUserById();
        return user;
    }
    //测试insert
    @RequestMapping(value="add")
    public String insertTransactional(
                                      @RequestParam(value = "user_id") Long user_id,
                                      @RequestParam(value = "order_id") Long order_id,
                                      @RequestParam(value = "nickName") String nickName,
                                      @RequestParam(value = "passWord") String passWord,
                                      @RequestParam(value = "userName") String userName
    ) {
        UserEntity user2 = new UserEntity();
        String nowTime = getId();
        user2.setId(nowTime);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        user1Service.insertTransactional(user2);
        return "insert success!";
    }
    //测试update
    @RequestMapping(value="update")
    public String updateTransactional(@RequestParam(value = "id") String id,
                                      @RequestParam(value = "user_id") Long user_id,
                                      @RequestParam(value = "order_id") Long order_id,
                                      @RequestParam(value = "nickName") String nickName,
                                      @RequestParam(value = "passWord") String passWord,
                                      @RequestParam(value = "userName") String userName
    ) {
        UserEntity user2 = new UserEntity();
        user2.setId(id);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        user1Service.updateTransactional(user2);
        return "update success!";
    }

    //测试delete
    @RequestMapping(value="delete")
    public String delete(@RequestParam(value = "id") Long id
    ) {
        user1Service.deleteById(id);
        return "delete success!";
    }

    private static String getId() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
        return df.format(new Date());
    }
}