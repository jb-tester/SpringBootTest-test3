package com.mytests.spring.springboot14.springtesting.test3.forTests.services;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyUsersEntity;
import com.mytests.spring.springboot14.springtesting.test3.forTests.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 1/24/2017.
 * Project: SpringBootTest-test3
 * *******************************
 */
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<MyUsersEntity> listAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<MyUsersEntity> findUsersByName(String name) {
        List<MyUsersEntity> users = usersRepository.findByName(name);
        return users;
    }
}
