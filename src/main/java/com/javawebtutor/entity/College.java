package com.javawebtutor.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="college")
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
    @ManyToAny(
               metaDef = "StudentMetaDef",
               metaColumn = @Column(name = "student_gender")
             )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(name = "college_students",
              joinColumns = @JoinColumn(name = "college_id"),
              inverseJoinColumns = @JoinColumn(name = "student_id")
             )
    private List<Student> students = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
