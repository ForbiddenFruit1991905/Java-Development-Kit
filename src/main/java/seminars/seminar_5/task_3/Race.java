package seminars.seminar_5.task_3;

import seminars.seminar_5.task_2.ThreadA;

import java.util.concurrent.CountDownLatch;

public class Race implements Runnable{
    private CountDownLatch readySignal;
    private CountDownLatch startSignal;
    private CountDownLatch finishSignal;

    public Race(CountDownLatch readySignal, CountDownLatch startSignal, CountDownLatch finishSignal) {
        this.readySignal = readySignal;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
    }

    @Override
    public void run() {
        try {
            readySignal.await();
            System.out.println("на старт!");
            Thread.sleep(100);
            System.out.println("внимание!");
            Thread.sleep(100);
            System.out.println("марш!");
            startSignal.countDown();
            finishSignal.await();
            System.out.println("Забег окончен!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
