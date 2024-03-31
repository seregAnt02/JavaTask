package task3;

abstract class Adapter implements Listener {
    void method1() {
        System.out.println("Method to method1 -> " + this.getClass());
    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {
        Listener.super.method4();
    }
}
