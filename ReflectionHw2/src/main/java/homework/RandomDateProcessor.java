package homework;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateProcessor {

    public static void processRandomDate(Object obj) throws IllegalAccessException {
        for (Field declaredField : obj.getClass().getDeclaredFields()){
            RandomDate annotation = declaredField.getAnnotation(RandomDate.class);
            if(annotation != null){
                long min = annotation.min();
                long max = annotation.max();

                declaredField.setAccessible(true);

                try {
                    declaredField.set(obj, new Date(
                            ThreadLocalRandom
                                    .current()
                                    .nextLong(min, max)
                    ));
                } catch (IllegalAccessException e){
                    System.err.println("Не удалось подставить рандомное значение: " + e);
                }
            }
        }

    }
}
