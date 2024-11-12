package seminars.seminar_5.task_2;

public class ThreadB  implements Runnable{
    private int counter = 100;
        private ThreadA threadA;

    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        while (counter >= 0) {
            if (threadA.isSwitcher()) {
                System.out.println(counter--);
            }
        }
    }
}
