package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) throws SQLException {
	 ConfigurableApplicationContext context	= SpringApplication.run(SpringDataDemoApplication.class, args);



		/*DataSource dataSource = context.getBean(DataSource.class);

		try(Connection connection = dataSource.getConnection()){
			try(Statement statement = connection.createStatement()){
				statement.execute("create table users(id bigint, name varchar(512))");
			}
			try(Statement statement = connection.createStatement()){
				statement.execute("insert into users(id, name) values(1,'Tom')");
			}
			try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery("select * from users");
				while (resultSet.next()){
					System.out.println(resultSet.getInt("id"));
					System.out.println(resultSet.getString("name"));
				}
			}
		}*/

	 UserRepository userRepository = context.getBean(UserRepository.class);

	 User user = new User();
	 user.setId(1L);
	 user.setName("Tom");

	 userRepository.save(user);

		Optional<User> foundUser = userRepository.findById(1L);
		foundUser.ifPresent(it -> System.out.println(it));

		userRepository.findById(1L).ifPresentOrElse(it -> System.out.println(it), () -> System.out.println("Не найден пользователь с таким идентификатором"));
	}

}
