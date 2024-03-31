
/*
Задача 4: Работа с анонимными классами
Создайте интерфейс Clickable с методом click().
В основном классе программы создайте анонимный класс, реализующий Clickable, и вызовите метод click().
* */

package task4;

public class  Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow() {
            @Override
            public void click() {
                System.out.println("Method click -> " + this.getClass());
            }
        };

        mainWindow.click();

    }
}
