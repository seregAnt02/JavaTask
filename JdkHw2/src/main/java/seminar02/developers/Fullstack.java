package seminar02.developers;

public class Fullstack extends Developer implements Backendable, Frontendable {
    @Override
    public void doBackendWork() {
        System.out.println("Good backend work!!!");
    }

    @Override
    public void doFrontendWork() {
        System.out.println("Good frontend work!!!");
    }

    public Fullstack(String name, int age) {
        super(name, age);
    }
}
