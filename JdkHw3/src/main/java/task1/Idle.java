package task1;

public class Idle implements Person {
    private String name;

    public Idle(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("I can't work");
    }

    @Override
    public String toString() {
        return "Idle{" +
                "name='" + name + '\'' +
                '}';
    }
}
