package com.mytests.spring.springboot14.springtesting.test3.forTests;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.FooEntity;
import com.mytests.spring.springboot14.springtesting.test3.forTests.repositories.FooRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 1/26/2017.
 * Project: SpringBootTest-test3
 * *******************************
 */
@RunWith(SpringRunner.class)
@JdbcTest
@TestPropertySource(properties = "spring.datasource.schema=classpath:sample.sql")
public class JdbcTestEmbeddedDataBase0 {
    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private DataSource source;

    @Autowired
    private JdbcTemplate template;

    @Autowired(required = false) // should not be available
    private FooRepository repository;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    TransactionTemplate transactionTemplate;
    @Autowired
    DataSourceTransactionManager transactionManager;

    @Test
    public void testNullBeans() throws Exception {
        Assert.assertNull(repository);
    }
    @Test
    public void testDataSourceType() throws Exception {
        String product = this.source.getConnection().getMetaData()
                .getDatabaseProductName();
        Assert.assertEquals(product,"H2");
    }
    @Test
    public void testEntity() throws Exception {
        FooRepository repo = new FooRepository(this.template);
        repo.save(new FooEntity(50,"Foo"));
        Collection<FooEntity> foos = repo.findAll();
        Assert.assertEquals(foos.size(),1);
        FooEntity entity = foos.iterator().next();
        Assert.assertEquals(entity.getId(),50);
        Assert.assertEquals(entity.getName(),"Foo");


    }
    @Test
    public void showBeansInContext() throws Exception {
        String[] beans = ctx.getBeanDefinitionNames();
        System.out.println("++++++++++++++Beans:++++++++++++++++++++++++");
        for (String bean : beans) {
                       System.out.println(bean);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
    }


}
