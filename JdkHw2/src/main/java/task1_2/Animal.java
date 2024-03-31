package task1_2;

public class Animal implements Runnable, Eater{

    @Override
    public void eat() {
        System.out.println("Animal eat -> " + this.getClass());
    }

    @Override
    public void run() {
        System.out.println("Animal to running -> " + this.getClass());
    }
}
