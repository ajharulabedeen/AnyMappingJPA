package com.javawebtutor;

import com.javawebtutor.entity.Boy;
import com.javawebtutor.entity.Girl;
import com.javawebtutor.entity.StudentInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateAnyDemo {
    private static EntityManager entityManager;

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
        entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Boy boy = new Boy();
//        boy.setId(3);
        boy.setName("Mukesh");
        boy.setAge(30);
        entityManager.persist(boy);

        Girl girl = new Girl();
//        girl.setId(3);
        girl.setName("Neerja");
        girl.setAge(25);
        entityManager.persist(girl);

        StudentInfo info1 = new StudentInfo();
//        info1.setId(1);
        info1.setStudent(boy);
        entityManager.persist(info1);
        StudentInfo info2 = new StudentInfo();
//        info2.setId(2);
        info2.setStudent(girl);
        entityManager.persist(info2);

        entityManager.getTransaction().commit();

        System.out.println("--data for id 1 --");
        StudentInfo info = (StudentInfo) entityManager.find(StudentInfo.class, 1);
        System.out.println("Name: " + info.getStudent().getName());
        System.out.println("Age: " + info.getStudent().getAge());
        System.out.println("--data for id 2 --");
        info = (StudentInfo) entityManager.find(StudentInfo.class, 2);
        System.out.println("Name: " + info.getStudent().getName());
        System.out.println("Age: " + info.getStudent().getAge());

        entityManager.close();
    }
}
