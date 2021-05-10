package com.redis.demo.service;

import com.redis.demo.domin.Manage;

public interface UserService {
    public String getAll(Manage uuid);

    String getManageAll(Manage uuid);

    public Manage insert();
    public void getdel();
}
