import java.sql.*;

public class Homework {

  /**
   * Повторить все, что было на семниаре на таблице Student с полями
   * 1. id - bigint
   * 2. first_name - varchar(256)
   * 3. second_name - varchar(256)
   * 4. group - varchar(128)
   *
   * Написать запросы:
   * 1. Создать таблицу
   * 2. Наполнить таблицу данными (insert)
   * 3. Поиск всех студентов
   * 4. Поиск всех студентов по имени группы
   *
   * Доп. задания:
   * 1. ** Создать таблицу group(id, name); в таблице student сделать внешний ключ на group
   * 2. ** Все идентификаторы превратить в UUID
   *
   * Замечание: можно использовать ЛЮБУЮ базу данных: h2, postgres, mysql, ...
   */

  public static void main(String[] args) {
      try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "root", "root")) {
          createTable(connection);
          insertTable(connection);
          findStudents(connection);
          System.out.println("----------------");
          findStudentsToGroupName(connection, "'1a'");
      } catch (SQLException e) {
          System.err.println("Не удалось подключиться к БД: " + e.getMessage());
      }
  }

    static void findStudentsToGroupName(Connection connection, String group) throws SQLException {
        // ResultSet
        try (Statement statement = connection.createStatement()) {
            String sql = "select id, first_name, second_name, group_name from student where group_name = " + group;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String second_name = resultSet.getString("second_name");
                String group_name = resultSet.getString("group_name");
                System.out.println("Все студенты по имени группы: " + String.format("%s, %s, %s, %s", id, first_name, second_name, group_name));
            }
        }
    }
    static void findStudents(Connection connection) throws SQLException {
        // ResultSet
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("""
        select id, first_name, second_name, group_name
        from student
        """);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String second_name = resultSet.getString("second_name");
                String group_name = resultSet.getString("group_name");
                System.out.println("Все студенты: " + String.format("%s, %s, %s, %s", id, first_name, second_name, group_name));
            }
        }
    }
    static void insertTable(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate("""
        insert into student(id, first_name, second_name, group_name) values
        (1, 'Ivan', 'Ivanov', '1a'),
        (2, 'Tom', 'Disney', '2b'),
        (3, 'Jim', 'Hopkins', '3c'),
        (4, 'Sidor', 'Sidorov', '1a')
        """);
            System.out.println("Количество вставленных строк: " + count);
        }
    }
    static void createTable(Connection connection) throws SQLException {
        // Statement - интерфейс, описывающий конкретный запрос в БД
        try (Statement statement = connection.createStatement()) {
            // execute, executeUpdate, executeQuery
            statement.execute("""
                    create table student(
                      id bigint,
                      first_name varchar(256),
                      second_name varchar(256),
                      group_name varchar(128)
                    )
                    """);
        }

    }
}
