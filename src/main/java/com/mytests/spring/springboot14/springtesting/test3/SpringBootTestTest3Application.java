package com.mytests.spring.springboot14.springtesting.test3;

import com.mytests.spring.springboot14.springtesting.test3.forTests.entities.MyChinsEntity;
import com.mytests.spring.springboot14.springtesting.test3.forTests.services.ChinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class SpringBootTestTest3Application implements CommandLineRunner {

	@Autowired private ChinsService chinsService;



	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestTest3Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		for(String arg : strings) {
			System.out.println(arg);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println("test chins:");
		System.out.println("the chinchilla with id==3:");
		System.out.println(chinsService.findChinById(3).getName());
		List<MyChinsEntity> chins = chinsService.listAll();
		for (Iterator<MyChinsEntity> iterator = chins.iterator(); iterator.hasNext(); ) {
			MyChinsEntity next = iterator.next();
			System.out.println(next.toString());
		}
	}
}
