
/*Напишите обобщенный метод compareArrays(), который принимает два массива и
        возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
        любого типа данных, но должны иметь одинаковую длину и содержать элементы одного
        типа.*/

package task3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class App {

    private static final int VALUE_BOUND = 10000;
    private static final int N_NULLS = 3;

    static record ItemType(Integer value) {
        @Override
        public String toString() {
            return String.format("%s", value != null ? value.toString() : "Null");
        }
    }

    public static void main(String[] args) {

        var rnd = ThreadLocalRandom.current();
        ItemType[] arrayA = new ItemType[20];
        // good values
        IntStream.range(0, arrayA.length).forEach(i -> {
            arrayA[i] = new ItemType(rnd.nextInt(VALUE_BOUND));
        });
        // contains null
        IntStream.range(0, N_NULLS).forEach(i -> {
            arrayA[rnd.nextInt(0, arrayA.length)] = new ItemType(null);
        });
        // nulls
        IntStream.range(0, N_NULLS).forEach(i -> {
            arrayA[rnd.nextInt(0, arrayA.length)] = null;
        });
        ItemType[] arrayB = new ItemType[20];
        IntStream.range(0, arrayA.length).forEach(i -> {
            arrayB[i] = arrayA[i] != null ? new ItemType(arrayA[i].value()) : null;
        });
        System.out.println("Исходные массивы:");
        System.out.println("arrayA: " + Arrays.toString(arrayA));
        System.out.println("arrayB: " + Arrays.toString(arrayB));
        System.out.println(
                ArrayUtils.<ItemType>compareArrays(arrayA, arrayB)
                        ? "Массивы одинаковые."
                        : "Массивы различаются!");
        arrayB[arrayB.length / 2] = new ItemType(VALUE_BOUND);
        System.out.println("\nИсходные массивы:");
        System.out.println("arrayA: " + Arrays.toString(arrayA));
        System.out.println("arrayB: " + Arrays.toString(arrayB));
        System.out.println(
                ArrayUtils.<ItemType>compareArrays(arrayA, arrayB)
                        ? "Массивы одинаковые."
                        : "Массивы различаются!");
    }
}
