import java.util.concurrent.CountDownLatch;

/*
 Задание 1. В качестве задачи предлагается решить классическую задачу про обедающих филосовов

 УсловиеЖ
  - Есть пять философов (потоки), которые могут либо обедать(выполнение кода) либо размышлять
  (ожидание).
  - Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 мииллисекунд.
  - После каждого приема пищи филосов должен размышлять.
  - Не должно возникнуть общей блокировки.
  - Философы не должны есть больше одного раза подряд.
* */
public class App {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        new Thread(new Leisure(latch, 500, "философов 1 ->")).start();
        new Thread(new Leisure(latch, 500, "философов 2 ->")).start();
        new Thread(new Leisure(latch, 500, "философов 3 ->")).start();
        new Thread(new Leisure(latch, 500, "философов 4 ->")).start();
        new Thread(new Leisure(latch, 500, "философов 5 ->")).start();


        latch.await();

        System.out.println("Философы закончили свой досуг.");
    }
}
