package com.wj.mapper;

import com.wj.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getUserById();

    void insert(UserEntity user);

    void update(UserEntity user);

    void deleteById(Long id);

}
