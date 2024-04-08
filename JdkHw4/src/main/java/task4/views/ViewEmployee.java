package task4.views;

import task4.models.Employee;
import task4.presents.EmployeeCollection;

import java.util.Map;

public class ViewEmployee {

    private EmployeeCollection employeeCollection;
    public ViewEmployee(EmployeeCollection employeeCollection){
        this.employeeCollection = employeeCollection;
    }

    public void add(Integer key, Employee value){
        System.out.println("Добавление сущности: " + key + " -> " + value);
    }
    public void serviceNumber(Map.Entry<Integer, Employee> entry){
        System.out.println("Номер табеля сотрудника: " + entry.getValue().getName() + " -> " +
                entry.getValue().getServiceNumber());
    }

    public  void phoneNumberToName(Map.Entry<Integer, Employee> entry){
        System.out.println("Номер телефона сотрудника: " + entry.getValue().getName() + " -> " +
                entry.getValue().getPhoneNumber());
    }

    public  void findStage(Map.Entry<Integer, Employee> entry){
        System.out.println( "Сотрудник по имени: " + entry.getValue().getName() + " со стажем работы: " +
                entry.getValue().getStage() + " года найден!");
    }

    public void showCollection(){
        for (var item : this.employeeCollection.getEmployeeCollection().entrySet()){
            System.out.println(item);
        }
    }
}
