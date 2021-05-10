package com.wj.service;

import com.wj.entity.UserEntity;
import com.wj.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper user1Mapper;

    public List<UserEntity> getUsers() {
        List<UserEntity> users=user1Mapper.getAll();
        return users;
    }

    public UserEntity getUserById() {
        UserEntity user=user1Mapper.getUserById();
        return user;
    }

    public void insertTransactional(UserEntity user) {
        try{
            user1Mapper.insert(user);
            log.error(String.valueOf(user));
        }catch(Exception e){
            log.error("find exception!");
            throw e;   // 事物方法中，如果使用trycatch捕获异常后，需要将异常抛出，否则事物不回滚。
        }
    }

    public void updateTransactional(UserEntity user) {
        try{
            user1Mapper.update(user);
            log.error(String.valueOf(user));
        }catch(Exception e){
            log.error("find exception!");
            throw e;   // 事物方法中，如果使用trycatch捕获异常后，需要将异常抛出，否则事物不回滚。
        }
    }

    public void deleteById(Long id) {
        try{
            user1Mapper.deleteById(id);
            log.error(id+"");
        }catch(Exception e){
            log.error("find exception!");
            throw e;   // 事物方法中，如果使用trycatch捕获异常后，需要将异常抛出，否则事物不回滚。
        }
    }
}