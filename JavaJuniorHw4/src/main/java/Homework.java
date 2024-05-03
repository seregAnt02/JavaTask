import models.Group;
import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
      try (Session session = sessionFactory.openSession()) {
        createStudent(session);
        createGroup(session);
        updateStudent(session, 1L);
        find(session);
        remove(session, 1L);
        selectAll(session);
      }
    }
  }

  private static void createGroup(Session session) {
      Group group = new Group(1L, "A1");
      session.beginTransaction();
      session.persist(group);
      session.getTransaction().commit();
      System.out.println("вставка группы: " + group);
  }
  private static void createStudent(Session session) {
      Student student = new Student(1L, "Ivanov", "Ivan", 1L);
      session.beginTransaction();
      session.persist(student);
      session.getTransaction().commit();
      System.out.println("вставка студента: " + student);
  }

  private static void updateStudent(Session session, Long id) {
      Student updatedStudent = selectStudentByID(session, id);
      updatedStudent.setFirst_name("Jim");
      updatedStudent.setLast_name("Hopkins");
      Transaction tx = session.beginTransaction();
      session.merge(updatedStudent);
      tx.commit();
      System.out.println("обновление студента: " + selectStudentByID(session, id));
  }

  private static Student selectStudentByID(Session session, Long id) {
    return session.find(Student.class, id);
  }

  static void find(Session session){
      Student student = session.find(Student.class, 1L);
      System.out.println(student); // Find
  }

  static void remove(Session session, Long id){
      Student student = selectStudentByID(session, id);
      Transaction tx = session.beginTransaction();
      session.remove(student); // Remove
      tx.commit();
      System.out.println("удаление студента:" + student);
  }

  /** 3. ... поупражняться с разными запросами ...*/
  private static void selectAll(Session session) {
      System.out.println("список студентов и групп: ");
      List<Group> groups = session.createQuery("FROM Group", Group.class).getResultList();
      groups.forEach(System.out::println);

      List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();
      students.forEach(System.out::println);
  }
}
