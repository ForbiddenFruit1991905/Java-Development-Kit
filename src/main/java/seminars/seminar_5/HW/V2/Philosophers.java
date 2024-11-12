package seminars.seminar_5.HW.V2;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Philosophers implements Runnable {
    private final int id;
    private final Lock leftFork;
    private final Lock rightFork;

    public Philosophers(int id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет.");
        Thread.sleep(new Random().nextInt(1000, 5000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " ест.");
        Thread.sleep(new Random().nextInt(1000, 5000));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                think();
                leftFork.lock();
                System.out.println("Взял левую вилку в руки");
                try {
                    rightFork.lock();
                    System.out.println("Взял правую вилку в руки");
                    try {
                        eat();
                    } finally {
                        rightFork.unlock();
                        System.out.println("Положил правую вилку в руки");
                    }
                } finally {
                    leftFork.unlock();
                    System.out.println("Положил левую вилку в руки");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

