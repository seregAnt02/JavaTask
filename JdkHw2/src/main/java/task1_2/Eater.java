package task1_2;

public interface Eater {
    void eat();

    default void sleep() {
        System.out.println("The method of sleeping -> " + this.getClass());
    }
}
