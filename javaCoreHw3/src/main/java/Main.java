 /*1 . Написать компоратор по фамилии
   2.Опишите класс руководителя (Manager), наследник от сотрудника.
     Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
     чтобы он мог поднять заработную плату всем, кроме руководителей. В основной программе создайте руководителя и
     поместите его в общий массив сотрудников.Повысьте зарплату всем сотрудникам и проследите,
     чтобы зарплата руководителя не повысилась.
   3. Добавить возможность сотрудникам брать на себя задачу (реализовать либо как String, либо как объект класса Task) -
   например, метод assign(Task task). У руководителя должна быть возможность ставить задачу сотруднику,
    используя перегрузку метода assign(...) и брать задачу себе.*/
 import java.time.LocalDate;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("Анализ по предыдущему выезду, по активной базе",
                "Petrov", "Petr", "+7-999-111-22-77", "Manager", 60000));
        employees.add(new Worker("Работа с дебеторкой в офисе","утром на оперативке",
                "вечером на оперативке","Ivanov",
                "Ivan", "Vanj", "worker",
                "+7-999-111-22-66", 50000, LocalDate.of(1970, 11, 17) ));


        for (int i = 0; i < employees.size(); i++){
            System.out.print(employees.get(i) + "\r\n");
        }

        employees.sort(new EmploySurnameComparator());

        Manager.addSalary(employees, 1000);

        Manager.assign(employees, "собрать заявки, согласно маршрута.", "Worker");

        Manager.assign(employees, "выезд по аудиту", "Manager");

        for (int i = 0; i < employees.size(); i++){
            System.out.print(employees.get(i) + "\r\n");
        }

    }
}
