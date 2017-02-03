package com.mytests.spring.springboot14.springtesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestApplicationTests {

	@Configuration
	@EnableAutoConfiguration
	static class Config{}

	@Test
	public void contextLoads() {
	}

}
