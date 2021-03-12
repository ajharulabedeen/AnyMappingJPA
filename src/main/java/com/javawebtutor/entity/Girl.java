package com.javawebtutor.entity;

import javax.persistence.*;

@Entity
@Table(name="girl")
public class Girl implements Student{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
