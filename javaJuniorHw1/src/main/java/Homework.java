

import java.util.*;
import java.util.stream.Collectors;

public class Homework {

    /**
     * Используя классы Person и Department, реализовать методы ниже:
     */
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Ivan", 26, 40000, new Department("ATI")),
                new Person("Tom", 33, 30000, new Department("Manager")),
                new Person("Kristina", 30, 25000, new Department("Manager")),
                new Person("Bill", 30, 30000, new Department("ATI")),
                new Person("Jim", 50, 45000, new Department("Work")),
                new Person("Boris", 55, 55000, new Department("Work")));

        System.out.println(personList);

        long count = countPersons(personList, 30, 20000);
        System.out.println("Количество сотрудников:" + count);

        OptionalDouble avg = averageSalary(personList, "ATI");
        System.out.println("Средния зарплата сотрудника, которые работают в департаменте: " + avg.getAsDouble());

        Map<Department, List<Person>> collectPerson = groupByDepartment(personList);
        System.out.println("Сгруппированы сотрудники, по департаментам:\r\n" + collectPerson);

        Map<Department, Double> collectDouble = maxSalaryByDepartment(personList);
        System.out.println("Максимальные зарплаты по отделам:\r\n" + collectDouble);

        Map<Department, List<String>> collectString = groupPersonNamesByDepartment(personList);
        System.out.println("Сгруппированы имена сотрудников по департаментам:\r\n" + collectString);

        List<Person> list = minSalaryPersons(personList);
        System.out.println("Сотрудники с минимальными зарплатами в своем отделе:\r\n" + list);
    }

    /**
     * Найти количество сотрудников, старше x лет с зарплатой больше, чем d
     */
    static long countPersons(List<Person> persons, int x, double d) {
        long count = persons.stream()
                .filter(f -> f.age > x && f.salary > d).count();
         return count;
    }

    /**
     * Найти среднюю зарплату сотрудников, которые работают в департаменте X
     */
    static OptionalDouble averageSalary(List<Person> persons, String x) {
        return persons.stream()
                .filter(it -> it.department.getName().contains(x))
                .mapToDouble(Person::getSalary)
                .average();
    }

    /**
     * Сгруппировать сотрудников по департаментам
     */
    static Map<Department, List<Person>> groupByDepartment(List<Person> persons) {
        Map<Department, List<Person>> collect = persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment));
        return collect;
    }

    /**
     * Найти
     */
    static Map<Department, Double> maxSalaryByDepartment(List<Person> persons) {
        Map<Department, Double> collect = persons.stream()
                .collect(Collectors.toMap(Person::getDepartment, Person::getSalary, Math::max));
        return collect;
    }

    /**
     * ** Сгруппировать имена сотрудников по департаментам
     */
    static Map<Department, List<String>> groupPersonNamesByDepartment(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Homework.Person::getDepartment,
                        Collectors.mapping(Homework.Person::getName,
                                Collectors.toList())));
    }

    /**
     * ** Найти сотрудников с минимальными зарплатами в своем отделе
     */
    static List<Person> minSalaryPersons(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(Person::getDepartment, p -> p,
                        (p1, p2) -> p1.getSalary() <= p2.getSalary() ? p1 : p2))
                .values()
                .stream()
                .toList();
    }

    private static class Person {
        private String name;
        private int age;
        private double salary;
        private Department department;

        public Person(String name, int age, double salary, Department department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", department=" + department +
                    '}' + "\r\n";
        }
    }

    private static class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}