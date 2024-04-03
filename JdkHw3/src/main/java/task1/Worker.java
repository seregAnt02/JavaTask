package task1;

public class Worker implements Person {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void haveRest() {
        System.out.println("I always work");
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
