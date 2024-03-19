import java.util.List;

public class Manager extends Employee {

    private String task;
    public Manager(String task, String surname, String name,
                   String phoneNumber, String position, int salary) {
        super(surname, name, phoneNumber, position, salary);
        this.task = task;
    }
    public static void addSalary(List<Employee> employees, int addAmount) {

        for (int i = 0; i < employees.size(); i++){
            if(employees.get(i) instanceof Worker){
                employees.get(i).setSalary(employees.get(i).getSalary() + addAmount);
                System.out.println( "Сотруднику: "+ employees.get(i).getClass().getTypeName() +
                        " -> зарплата успешно повышена!");
            }
        }
    }

    public static void assign(List<Employee> employees, String task, String position){

        for (int i = 0; i < employees.size(); i++){
            if(position == employees.get(i).getClass().getTypeName()){
                ((Manager) employees.get(i)).setTask(task);
                System.out.println("Сотруднику: " + employees.get(i).getClass().getTypeName() + " -> задача: " + task);
            }
        }
    }

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    @Override
    public String toString() {
        return "Manager{" +
                "setTask='" + task + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", position='" + super.getPosition() + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }
}
