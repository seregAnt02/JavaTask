public class Employee{
    private String surname;
    private String name;
    private String phoneNumber;
    private String position;
    private int salary;

    public Employee(String surname, String name, String phoneNumber, String position, int salary) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
