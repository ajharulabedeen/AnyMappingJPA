package com.javawebtutor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_DB")
public class Employee {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fistName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dept")
    private String dept;

    @Column(name = "age")
    private String age;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String dept) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDept(dept);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
