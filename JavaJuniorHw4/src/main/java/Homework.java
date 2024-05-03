import models.Group;
import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Homework {

  /**
   * Перенести структуру дз третьего урока на JPA:
   * 1. Описать сущности Student и Group
   * 2. Написать запросы: Find, Persist, Remove
   * 3. ... поупражняться с разными запросами ...
   */

  public static void main(String[] args) throws SQLException {

    try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "")) {
      run(connection);
    }
  }


  static void run(Connection connection){
    Configuration configuration = new Configuration().configure();
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
      persist(sessionFactory);
      find(sessionFactory);
      remove(sessionFactory);
    }
  }

  static Student student;
  static void persist(SessionFactory sessionFactory){
    try (Session session = sessionFactory.openSession()) {
      student = new Student();
      student.setId(123L);
      student.setFirst_name("Petr");
      student.setLast_name("Petrov");

      Group group = new Group();
      group.setName("1A");
      //group.addStudents(student);

      Transaction tx = session.beginTransaction();
      session.persist(student); // Persist
      //session.persist(group);
      tx.commit();

    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }


  static void find(SessionFactory sessionFactory){
    try (Session session = sessionFactory.openSession()) {
      Student student = session.find(Student.class, 123L);
      System.out.println(student); // Find
    }
  }

  static void remove(SessionFactory sessionFactory){
    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      session.remove(student); // Remove
      tx.commit();
    }
  }
}
