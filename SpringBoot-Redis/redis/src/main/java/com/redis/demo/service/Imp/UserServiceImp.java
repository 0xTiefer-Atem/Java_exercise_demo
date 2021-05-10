package com.redis.demo.service.Imp;

import com.redis.demo.dao.UserDao;
import com.redis.demo.domin.Manage;
import com.redis.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImp implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String getAll(Manage uuid) {
        String key = "管理员—" + uuid;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        boolean hashkey = redisTemplate.hasKey(key);
        if (hashkey){
            Manage manage =new Manage();
            LOGGER.info("  "  + manage.toString() );
        }

        String manage = userDao.getAll(uuid);
        operations.set("aaa",manage);
        System.out.println("缓存成功");
        System.out.println(key+"\t"+manage);
        operations.set(key,manage,10,TimeUnit.SECONDS);
        return manage;
    }

    @Override
    public String getManageAll(Manage uuid) {
//        String key = "管理员—" + uuid;
//        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//
//        boolean hashkey = redisTemplate.hasKey(key);
//        if (hashkey){
//            Manage manage =new Manage();
//            LOGGER.info("  "  + manage.toString() );
//        }
//
//        String manage = userDao.getAll(uuid);
//        operations.set("aaa",manage);
//        System.out.println("缓存成功");
//        operations.set(key,manage,10,TimeUnit.SECONDS);
//        return manage;
        return null;
    }

    @Override
    public Manage insert() {
        return userDao.insert();
    }

    @Override
    public void getdel() {

    }
}
