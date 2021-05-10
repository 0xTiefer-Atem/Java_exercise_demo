package com.redis.demo.dao;

import com.redis.demo.domin.Manage;

public interface UserDao {
    String getAll(Manage uuid);
    Manage insert();
    void getdel();
}
