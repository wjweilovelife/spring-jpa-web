package com.pactera.api.service;

import com.pactera.entity.seckillentity.User;
import com.pactera.repository.seckillrepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjwei
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> queryUserList() {
        return userRepository.findAll();
    }
}
