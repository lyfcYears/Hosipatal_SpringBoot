package com.hospital.service.adminlmp;

import com.hospital.model.admin.User;
import com.hospital.service.admin.UserServer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName UserServerlmp
 * @Description 请输入你的简化描述！
 * @Author 方聪
 * @Date 2019/6/6 10:51
 * @Version 1.0
 **/
@Service
public class UserServerlmp implements UserServer {


    @Override
    public User findByUserName(String username) {
        if(username.equals("fc")){
            User user = new User();
            user.setUsername("fc");
            user.setPassword("123456");
            return user;
        } else if(username.equals("zs")){
            User user = new User();
            user.setUsername("zs");
            user.setPassword("123456");
            return user;
        }else {
            return null;
        }

    }

    @Override
    public List<String> selectPermissionByUserId(String username) {
        System.out.println("我进入授权了噢噢噢噢噢噢噢噢哦哦哦"+username);
        List<String> sf = new ArrayList<>();
        if(username.equals("fc")){
            String path = "/od/hi";
            sf.add(path);
        } else if(username.equals("zs")){
            String path = "/zs/hi";
            sf.add(path);
        }
        return sf;
    }
}
