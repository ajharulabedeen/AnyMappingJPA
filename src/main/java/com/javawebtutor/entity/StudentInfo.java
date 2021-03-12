package com.javawebtutor.entity;

import org.hibernate.annotations.Any;

import javax.persistence.*;

@Entity
@Table(name="student_info")
public class StudentInfo {
	@Id
	private int id;
    @Any(
         metaDef = "StudentMetaDef",
         metaColumn = @Column(name = "student_gender")
    )
    @JoinColumn( name = "student_id" )
	private Student student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
