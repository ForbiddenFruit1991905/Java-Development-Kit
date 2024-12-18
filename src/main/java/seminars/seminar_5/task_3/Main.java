package seminars.seminar_5.task_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/*
3 бегуна должны прийти к старту гонки.
Программа должна гарантировать, что гонка начнется только
когда все три участника будут на старте.
Программа должна отсчитать “На старт”, “Внимание”, “Марш”.
Программа должна завершиться когда все участники закончат гонку.
Подумайте об использовании примитива синхронизации.
 */
public class Main {
    private static final int count_runners = 3;
    public static void main(String[] args) {
        CountDownLatch readySignal = new CountDownLatch(count_runners);
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(count_runners);

        List<Runner> runners = new ArrayList<>(Arrays.asList(
                new Runner("Вася", readySignal, startSignal, finishSignal),
                new Runner("Петя", readySignal, startSignal, finishSignal),
                new Runner("Ваня", readySignal, startSignal, finishSignal)
        ));
        new Thread(new Race(readySignal, startSignal, finishSignal)).start();
        for (Runner runner : runners) {
            new Thread(runner).start();
        }
    }
}
