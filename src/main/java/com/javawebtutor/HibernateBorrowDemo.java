package com.javawebtutor;

//import com.concretepage.entity.Boy;
//import com.concretepage.entity.Girl;
//import com.concretepage.entity.StudentInfo;

import com.javawebtutor.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateBorrowDemo {
    //	private static EntityManager em;
    private static EntityManager session;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
        session = emf.createEntityManager();

        session.getTransaction().begin();

        DVD dvd = new DVD();
        dvd.setName("dvd1");
        session.persist(dvd);

        VHS vhs = new VHS();
        vhs.setName("vhs1");
        session.persist(vhs);

        Book book = new Book();
        book.setName("book1");
        session.persist(book);

        Borrow borrow1 = new Borrow();
        borrow1.setItem(dvd);
        session.persist(borrow1);

        Borrow borrow2 = new Borrow();
        borrow2.setItem(vhs);
        session.persist(borrow2);

        Borrow borrow3 = new Borrow();
        borrow3.setItem(book);
        session.persist(borrow3);

        session.getTransaction().commit();

//        System.out.println("--data for id 1 --");
//        StudentInfo info = (StudentInfo) session.find(StudentInfo.class, 1);
//        System.out.println("Name: " + info.getStudent().getName());
//        System.out.println("Age: " + info.getStudent().getAge());
//        System.out.println("--data for id 2 --");
//        info = (StudentInfo) session.find(StudentInfo.class, 2);
//        System.out.println("Name: " + info.getStudent().getName());
//        System.out.println("Age: " + info.getStudent().getAge());

        session.close();
    }
}
