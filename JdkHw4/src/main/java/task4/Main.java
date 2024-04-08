
/*Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
        Табельный номер
        Номер телефона
        Имя
        Стаж
        Добавить метод, который ищет сотрудника по стажу (может быть список)
        Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
        Добавить метод, который ищет сотрудника по табельному номеру
        Добавить метод добавление нового сотрудника в справочник сотрудников*/

package task4;

import task4.models.Manager;
import task4.models.Worker;
import task4.presents.EmployeeCollection;

public class Main {
    public static void main(String[] args) {

        EmployeeCollection employeeCollection = new EmployeeCollection();

        // добавление нового сотрудника в справочник сотрудников
        employeeCollection.add(2, new Worker(2, "222", "Ivan", 3));
        employeeCollection.add(3, new Worker(3, "333", "Jim", 3));
        employeeCollection.add(1, new Manager(1, "111", "Tom", 4));

        employeeCollection.getViewEmployee().showCollection();

        // Ищет сотрудника по стажу
        employeeCollection.findStage("Ivan", 3);

        // Ищет сотрудника по табельному номеру
        employeeCollection.serviceNumber(1);

        // Выводит номер телефона сотрудника по имени
        employeeCollection.phoneNumberToName("Ivan");


    }
}
