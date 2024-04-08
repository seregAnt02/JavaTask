package task4.presents;

import task4.models.Employee;
import task4.views.ViewEmployee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCollection {
    private Map<Integer, Employee> employeeCollection;
    private ViewEmployee viewEmployee;

    public EmployeeCollection() {
        this.employeeCollection = new HashMap<>();
        this.viewEmployee = new ViewEmployee(this);
    }

    public void add(Integer key, Employee value){
        this.employeeCollection.put(key, value);
        viewEmployee.add(key, value);
    }

    public void serviceNumber(int serviceNumber){
        for (var item : this.employeeCollection.entrySet()){
            if(serviceNumber == item.getValue().getServiceNumber()){
                viewEmployee.serviceNumber(item);
            }
        }
    }
    public void phoneNumberToName(String name){
        for (var item : this.employeeCollection.entrySet()){
            if(name == item.getValue().getName()){
                viewEmployee.phoneNumberToName(item);
            }
        }
    }
    public void findStage(String name, Integer stage){
        for (var item : this.employeeCollection.entrySet()){
                if(item.getValue().getStage() == stage && item.getValue().getName() == name)
                    viewEmployee.findStage(item);
        }
    }

    public Map<Integer, Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public ViewEmployee getViewEmployee() {
        return viewEmployee;
    }
}
