package com.mytests.spring.springboot14.springtesting.test3.forTests.services;


import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyChinsEntity;
import com.mytests.spring.springboot14.springtesting.test3.forTests.repositories.ChinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 12/19/2016.
 * Project: SpringJPA20_test0
 * *******************************
 */
@Service
public class ChinsServiceImpl implements ChinsService {


    @Autowired
    private ChinsRepository chinsRepository;

    @Override
    public List<MyChinsEntity> listAll() {
        return chinsRepository.findAll();
    }

    @Override
    public List<MyChinsEntity> listBoys() {
        return chinsRepository.findBySexEquals("");
    }

    @Override
    public List<MyChinsEntity> listGirls() {
        return chinsRepository.findBySexEquals("");
    }

    @Override
    public MyChinsEntity findChinById(int id) {
        return chinsRepository.findById(id);
    }
}
