package com.mytests.spring.springboot14.springtesting.test3.forTests.entities;

public class FooEntity {

	private final int id;

	private String name;

	public FooEntity(int id, String name) {
        this.id = id;
		this.name = name;
	}

	public FooEntity(int id) {
		this(id, null);
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}