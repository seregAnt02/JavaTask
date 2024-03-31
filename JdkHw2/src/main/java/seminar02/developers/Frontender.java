package seminar02.developers;

public class Frontender extends Developer implements Backendable, Frontendable {
    @Override
    public void doBackendWork() {
        System.out.println("Very bad backend work!!!");
    }

    @Override
    public void doFrontendWork() {
        System.out.println("Good frontend work!!!");
    }

    Frontender(String name, int age) {
        super(name, age);
    }
}
