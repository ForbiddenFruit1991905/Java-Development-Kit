package seminars.seminar_5.HW.V1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    private final int idP;
    private Forks fork;
    private Semaphore semaphore;

    public Philosopher(int idP, Forks fork, Semaphore semaphore) {
        this.idP = idP;
        this.fork = fork;
        this.semaphore = semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + idP + " погрузился в размышления.");
        Thread.sleep(new Random().nextInt(1000, 5000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Философ " + idP + " ест.");
        Thread.sleep(new Random().nextInt(1000, 5000));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                think();

                semaphore.acquire(); // Попытка захвата общего ресурса

                fork.takeForks();
                eat();

                fork.putDownForks();

                semaphore.release(); // Освобождение общего ресурса
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

