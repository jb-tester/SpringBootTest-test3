package com.mytests.spring.springboot14.springtesting.test3.forTests.repositories;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyUsersEntity;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 1/24/2017.
 * Project: SpringBootTest-test3
 * *******************************
 */
@RepositoryDefinition(domainClass = MyUsersEntity.class, idClass = Integer.class)
public interface UsersRepository {
    List<MyUsersEntity> findAll();
    List<MyUsersEntity> findByName(String name);
}
