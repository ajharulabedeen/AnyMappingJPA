package com.javawebtutor;

//import com.concretepage.entity.Boy;
//import com.concretepage.entity.College;
//import com.concretepage.entity.Girl;
//import com.concretepage.entity.Student;

import com.javawebtutor.entity.Boy;
import com.javawebtutor.entity.College;
import com.javawebtutor.entity.Girl;
import com.javawebtutor.entity.Student;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class HibernateManyToAnyDemo {

    private static EntityManager session;

    public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
        session = emf.createEntityManager();

        session.getTransaction().begin();

        Boy boy = new Boy();
        boy.setId(2);
        boy.setName("Mukesh");
        boy.setAge(30);
        session.persist(boy);

        Girl girl = new Girl();
        girl.setId(2);
        girl.setName("Neerja");
        girl.setAge(25);
        session.persist(girl);

        College college = new College();
        college.setId(2);
        college.setName("ABCD");
        List<Student> students = new ArrayList<>();
        students.add(boy);
        students.add(girl);
        college.setStudents(students);
        session.persist(college);

        session.getTransaction().commit();

        College col = (College) session.find(College.class, 1);
        for (Student student : col.getStudents()) {
            System.out.println(student.getName() + ":" + student.getAge());
        }
        session.close();
//		HibernateUtil.closeSessionFactory();
    }
}
