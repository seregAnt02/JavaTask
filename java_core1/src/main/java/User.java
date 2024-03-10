import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class User {
    private  String name;
    private  int age;
    private  int salary;
}
