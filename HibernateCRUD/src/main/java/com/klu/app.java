package com.klu;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class app {
    public static void main(String[] args) {
        // CREATE
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        Student s2 = new Student(102, "Mohan", "CSE");
        Student s3 = new Student(103, "Hemanth", "CSE");
        Student s4 = new Student(104, "Koushik", "CSE");
        Student s5 = new Student(105, "Amith", "CSE");
        Student s6 = new Student(106, "Harsha", "CSE");
       
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        tx.commit();
        session.close();
        System.out.println("Student Inserted");
        
        // READ
        session = HibernateUtil.getSessionFactory().openSession();
        Student s = session.get(Student.class, 101);
        System.out.println(s.getName() + " " + s.getDept());
        session.close();
        
        // UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        s.setDept("AI & DS");
        session.update(s);
        tx.commit();
        session.close();
        System.out.println("Student Updated");
        
        // DELETE
        //session = HibernateUtil.getSessionFactory().openSession();
        //tx = session.beginTransaction();
        //session.delete(s);
        //tx.commit();
        //session.close();
        //System.out.println("Student Deleted");
    }}
