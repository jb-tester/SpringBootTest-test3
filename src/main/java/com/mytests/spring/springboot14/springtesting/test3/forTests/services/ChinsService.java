package com.mytests.spring.springboot14.springtesting.test3.forTests.services;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyChinsEntity;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 1/24/2017.
 * Project: SpringBootTest-test3
 * *******************************
 */
public interface ChinsService {
    List<MyChinsEntity> listAll();
    List<MyChinsEntity> listBoys();
    List<MyChinsEntity> listGirls();
    MyChinsEntity findChinById(int id);
}
