package com.hospital.service.admin;

import com.hospital.model.admin.User;

import java.util.List;

public interface UserServer {
    User findByUserName(String username);

    List<String> selectPermissionByUserId(String username);
}
