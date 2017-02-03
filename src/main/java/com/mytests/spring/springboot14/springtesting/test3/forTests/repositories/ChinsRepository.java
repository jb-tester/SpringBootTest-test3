package com.mytests.spring.springboot14.springtesting.test3.forTests.repositories;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyChinsEntity;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = MyChinsEntity.class, idClass = Integer.class)
public interface ChinsRepository {
    List<MyChinsEntity> findAll();
    List<MyChinsEntity> findBySexEquals(String sex);
    MyChinsEntity findById(int id);
}