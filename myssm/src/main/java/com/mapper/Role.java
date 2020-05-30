package com.mapper;

import com.entity.User;

public interface Role {

    public User findByUserId(int id);
}
