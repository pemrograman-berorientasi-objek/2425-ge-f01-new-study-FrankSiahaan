package pbo.model;

import java.util.*;
import javax.persistence.*;

public class Exec {

    private EntityManager entityManager;

    public Exec(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cleanTable() {
        String[] sql = {
            "DELETE FROM Student",
            "DELETE FROM Course"
        };

        entityManager.getTransaction().begin();
        for (String s : sql) {
            entityManager.createQuery(s).executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

    public void addStudent(String[] data) {
        entityManager.getTransaction().begin();
        Student student = new Student(data[1], data[2], data[3]);
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public void addCourse(String[] data) {
        entityManager.getTransaction().begin();
        Course course = new Course(data[1], data[2], data[3], data[4]);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    public void showStudent() {
        String sql = "SELECT a FROM Student a ORDER BY a.nim";
        List<Student> students = entityManager.createQuery(sql, Student.class).getResultList();
        for (Student std : students) {
            System.out.println(std);
        }
    }

    public void showCourse() {
        String sql = "SELECT a FROM Course a ORDER BY a.kode";
        List<Course> courses = entityManager.createQuery(sql, Course.class).getResultList();
        for (Course crs : courses) {
            System.out.println(crs);
        }
    }

    public void Enroll(String[] data) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, data[1]);
        Course course = entityManager.find(Course.class, data[2]);
        if (student != null && course != null) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            entityManager.persist(student);
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().rollback();
        }
    }

    public void showNim(String[] data) {
        Student student = entityManager.find(Student.class, data[1]);
        System.out.println(student);
        List<Course> courses = student.getCourses();
        Collections.sort(courses, Comparator.comparing(Course::getKode));

        for (Course crs : courses) {
            System.out.println(crs);
        }
    }
}
