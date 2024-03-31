package task3;

public interface Listener {
    void method2();
    void method3();

    default void method4() {
        System.out.println("Method to default.");
    }
}
