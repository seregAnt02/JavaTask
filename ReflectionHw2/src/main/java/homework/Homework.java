package homework;

import java.util.Date;

public class Homework {

  /**
   *  1. Создать аннотацию RandomDate со следующими возможностями:
   *  1.1 Если параметры не заданы, то в поле должна вставляться рандомная дата в диапазоне min, max.
   *  1.2 Аннотация должна работать с полем типа java.util.Date.
   *  1.3 Должна генерить дату в диапазоне [min, max)
   *  1.4 ** Научиться работать с полями LocalDateTime, LocalDate, Instant, ... (классы java.time.*)
   *
   *  Реализовать класс RandomDateProcessor по аналогии с RandomIntegerProcessor, который обрабатывает аннотацию.
   */

  public static void main(String[] args) throws IllegalAccessException {
      MyClass myClass = new MyClass();
      RandomDateProcessor.processRandomDate(myClass);

    System.out.println(myClass.dateRandom);
  }

  private static class MyClass{
    @RandomDate
    private Date dateRandom;
  }

}
