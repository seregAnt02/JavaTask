import java.util.Comparator;

public class EmploySurnameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
