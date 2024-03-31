
/*
Задача 3: Работа с адаптерами и частичной реализацией интерфейсов
Создайте интерфейс Listener с большим количеством методов.
Создайте абстрактный класс Adapter, который реализует интерфейс Listener, оставляя все методы пустыми.
Создайте класс MouseAdapter, который расширяет Adapter и переопределяет только один метод.
* */

package task3;

public class Main {

    public static void main(String[] args) {
        Adapter adapter = new MouseAdapter();
        adapter.method4();
    }
}
