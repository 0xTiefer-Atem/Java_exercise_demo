package com.redis.demo.controller;

import com.redis.demo.domin.Manage;
import com.redis.demo.service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContronller {
    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public String All(@RequestParam(value = "uuid") String uuid){
        Manage manage = new Manage();
        manage.setUuid(uuid);
        return userServiceImp.getAll(manage);
    }
}
