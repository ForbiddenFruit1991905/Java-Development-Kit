package seminars.seminar_5.HW;

import java.util.concurrent.locks.Lock;
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
    private static Lock[] forkLocks = new ReentrantLock[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forkLocks[i] = new ReentrantLock();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Forks(i, forkLocks[i], forkLocks[(i + 1) % NUM_PHILOSOPHERS]);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, forks[i]);
            new Thread(philosophers[i]).start();
        }
    }
}
