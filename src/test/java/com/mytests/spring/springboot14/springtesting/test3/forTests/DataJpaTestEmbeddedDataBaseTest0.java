package com.mytests.spring.springboot14.springtesting.test3.forTests;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyUsersEntity;
import com.mytests.spring.springboot14.springtesting.test3.forTests.repositories.UsersRepository;
import com.mytests.spring.springboot14.springtesting.test3.forTests.services.UsersService;
import com.mytests.spring.springboot14.springtesting.test3.forTests.services.UsersServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 1/24/2017.
 * Project: SpringBootTest-test3
 * *******************************
 */
@RunWith(SpringRunner.class)
@DataJpaTest()
public class DataJpaTestEmbeddedDataBaseTest0 {

     @Autowired
     private TestEntityManager entityManager;

     @Autowired
     private UsersRepository repository;

    @Autowired(required = false) // @Service-annotated class should not be available
    private UsersService usersService;

    @Test
    public void testNoComponentsAvailable() throws Exception {
        Assert.assertNull(usersService);
    }

    @Test
    public void testExample() throws Exception {
        int amount = repository.findAll().size();
        this.entityManager.persist(new MyUsersEntity(amount,"sboot", "1234"));
        MyUsersEntity user = this.repository.findByName("sboot").get(0);
        Assert.assertEquals(user.getName(),"sboot");
        Assert.assertEquals(user.getPassword(),"1234");
        System.out.println(user.toString());

    }
}
