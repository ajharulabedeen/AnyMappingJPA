package com.javawebtutor;

//import com.concretepage.entity.Boy;
//import com.concretepage.entity.Girl;
//import com.concretepage.entity.StudentInfo;

import com.javawebtutor.entity.Boy;
import com.javawebtutor.entity.Girl;
import com.javawebtutor.entity.StudentInfo;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateAnyDemo {
    //	private static EntityManager em;
    private static EntityManager session;

    public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
        session = emf.createEntityManager();

        session.getTransaction().begin();

        Boy boy = new Boy();
        boy.setId(3);
        boy.setName("Mukesh");
        boy.setAge(30);
        session.persist(boy);

        Girl girl = new Girl();
        girl.setId(3);
        girl.setName("Neerja");
        girl.setAge(25);
        session.persist(girl);

        StudentInfo info1 = new StudentInfo();
        info1.setId(1);
        info1.setStudent(boy);
        session.persist(info1);
        StudentInfo info2 = new StudentInfo();
        info2.setId(2);
        info2.setStudent(girl);
        session.persist(info2);

        session.getTransaction().commit();

        System.out.println("--data for id 1 --");
        StudentInfo info = (StudentInfo) session.find(StudentInfo.class, 1);
        System.out.println("Name: " + info.getStudent().getName());
        System.out.println("Age: " + info.getStudent().getAge());
        System.out.println("--data for id 2 --");
        info = (StudentInfo) session.find(StudentInfo.class, 2);
        System.out.println("Name: " + info.getStudent().getName());
        System.out.println("Age: " + info.getStudent().getAge());

        session.close();
        session.close();
//        HibernateUtil.closeSessionFactory();
    }
}
