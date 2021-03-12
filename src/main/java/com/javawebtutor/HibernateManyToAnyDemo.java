package com.javawebtutor;

//import com.concretepage.entity.Boy;
//import com.concretepage.entity.College;
//import com.concretepage.entity.Girl;
//import com.concretepage.entity.Student;

import com.javawebtutor.entity.Boy;
import com.javawebtutor.entity.College;
import com.javawebtutor.entity.Girl;
import com.javawebtutor.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class HibernateManyToAnyDemo {

    private static EntityManager entityManager;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
        entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Boy boy = new Boy();
        boy.setName("Mukesh");
        boy.setAge(30);
        entityManager.persist(boy);

        Girl girl = new Girl();
        girl.setName("Neerja");
        girl.setAge(25);
        entityManager.persist(girl);

        College college = new College();
        college.setName("ABCD");
        List<Student> students = new ArrayList<>();
        students.add(boy);
        students.add(girl);
        college.setStudents(students);
        entityManager.persist(college);

        entityManager.getTransaction().commit();

        College col = (College) entityManager.find(College.class, 1);
        for (Student student : col.getStudents()) {
            System.out.println(student.getName() + ":" + student.getAge());
        }
        entityManager.close();
    }
}
