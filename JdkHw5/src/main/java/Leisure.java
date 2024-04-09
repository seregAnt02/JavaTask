import java.util.concurrent.CountDownLatch;

public class Leisure extends Thread{

    private CountDownLatch latch;
    private int eat;
    private int delay;
    private String name;
    private int quantityEat;

    public Leisure(CountDownLatch latch, int delay, String name) {
        this.latch = latch;
        this.delay = delay;
        this.name = name;
        eat = 3;
        quantityEat = eat;
    }

    @Override
    public void run() {
        try {
            while (eat > 0) {
                eat--;
                System.out.println(name + " обедает " +  (quantityEat - eat) + "-ый раз.");
                Thread.sleep(delay);

                System.out.println(name + " философов размышляет " + (quantityEat - eat) + " раз.");
            }

            latch.countDown();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getEat() {
        return eat;
    }
}
