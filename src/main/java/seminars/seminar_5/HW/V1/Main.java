package seminars.seminar_5.HW.V1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/*
Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
Вилки лежат на столе между каждой парой ближайших философов.
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать).
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза.
 */
public class Main {
    private static final int NUM_PHILOSOPHERS = 5;
    private static Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
    private static Forks[] forks = new Forks[NUM_PHILOSOPHERS];
    private static Semaphore semaphore = new Semaphore(NUM_PHILOSOPHERS - 1);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Forks(i, new ReentrantLock(), new ReentrantLock());
            philosophers[i] = new Philosopher(i, forks[i], semaphore);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            new Thread(philosophers[i]).start();
        }
    }
}

