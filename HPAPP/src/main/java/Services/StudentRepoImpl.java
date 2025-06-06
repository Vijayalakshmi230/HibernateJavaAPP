package Services;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class StudentRepoImpl implements StudentRepo {

    private static SessionFactory factory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml"); // Make sure this file exists in your classpath
            factory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
        }
    }

    @Override
    public String addStudent(Student student) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
            return "Student added successfully.";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return "Failed to add student: " + e.getMessage();
        }
    }

    @Override
    public String updateStudent(Student student) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
            return "Student updated successfully.";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return "Failed to update student: " + e.getMessage();
        }
    }

    @Override
    public String deleteStudent(int studentId) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
                tx.commit();
                return "Student deleted successfully.";
            } else {
                return "Student not found.";
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return "Failed to delete student: " + e.getMessage();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
