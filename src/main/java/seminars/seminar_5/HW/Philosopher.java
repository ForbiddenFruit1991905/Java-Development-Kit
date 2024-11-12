
package seminars.seminar_5.HW;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {

    private final int idP;
    private Forks fork;

    public Philosopher(int idP, Forks fork) {
        this.idP = idP;
        this.fork = fork;
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
                fork.getLeftFork().lock();

                try {
                    fork.getRightFork().lock();
                    fork.takeForks();
                    try {
                        eat();
                    } finally {
                        fork.putDownForks();
                        fork.getRightFork().unlock();
                    }
                } finally {
                    fork.getLeftFork().unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

