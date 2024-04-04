
/*Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
        Класс должен иметь методы getFirst(), getSecond() для получения значений
        пары, а также переопределение метода toString(), возвращающее строковое представление пары.*/

package task4;

public class App {

    public static void main(String[] args) {

        Pair<Integer, String> pair1 = new Pair<>(42, "Hello");
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        System.out.println("Pair 1: " + pair1.toString());
        System.out.println("First value of Pair 2: " + pair2.getFirst());
        System.out.println("Second value of Pair 2: " + pair2.getSecond());
    }
}
