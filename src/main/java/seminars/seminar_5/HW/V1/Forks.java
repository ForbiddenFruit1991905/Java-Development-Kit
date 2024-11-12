
package seminars.seminar_5.HW.V1;

import java.util.concurrent.locks.Lock;

public class Forks {
    private final int idF;
    private boolean flag;
    private final Lock leftFork;
    private final Lock rightFork;

    public Forks(int idF, Lock leftFork, Lock rightFork) {
        this.idF = idF;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public Lock getLeftFork() {
        return leftFork;
    }

    public Lock getRightFork() {
        return leftFork;
    }

    public void takeFork() throws InterruptedException {
        synchronized (this) {
            while (!flag) {
                wait();
            }
            flag = false;
        }
    }

    public void putDownFork() {
        synchronized (this) {
            flag = true;
            notifyAll();
        }
    }

    public void takeForks() throws InterruptedException {
        synchronized (leftFork) {
            takeFork();
            System.out.println("Философ взял левую вилку " + idF);
            synchronized (rightFork) {
                takeFork();
                System.out.println("Философ взял правую вилку " + idF);
            }
        }
    }

    public void putDownForks() {
        synchronized (leftFork) {
            putDownFork();
            synchronized (rightFork) {
                putDownFork();
                System.out.println("Философ положил вилки " + idF + " и " + idF);
            }
        }
    }
}


