package seminar02.developers;

public class Backender extends Developer implements Backendable, Frontendable {
    @Override
    public void doBackendWork() {
        System.out.println("Good backend work!!!");
    }

    @Override
    public void doFrontendWork() {
        System.out.println("Can't do frontend work!");
    }

    public Backender(String name, int age) {
        super(name, age);
    }
}
