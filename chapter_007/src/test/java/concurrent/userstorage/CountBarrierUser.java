package concurrent.userstorage;

public class CountBarrierUser {
    public static void main(String[] args) throws InterruptedException {
        int total = 0;
        CountBarrier counter = new CountBarrier(total);

        Thread counterThread = new Thread(() -> {
            counter.count();

        });

        Thread counterThread2 = new Thread(() -> {
            counter.count();

        });
        Thread executorThread = new Thread(() -> {
            System.out.println("Check condition");
            System.out.println(" /total is" + counter.getTotal());
            counter.await();
            System.out.println("Executor Work");
            System.out.println(" /total is" + counter.getTotal());

        });

        counterThread.start();
        counterThread2.start();
        executorThread.start();
        counterThread.join();
        counterThread2.join();
        executorThread.join();
    }
}
