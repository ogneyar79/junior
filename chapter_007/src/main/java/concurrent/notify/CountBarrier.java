package concurrent.notify;

public class CountBarrier {

    private final Object monitor = this;

    private volatile int total;

    private volatile int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public void count() {
        synchronized (monitor) {

            this.count++;
            System.out.println("Count" + "" + this.count);
            total = this.count;
            monitor.notify();
        }


    }

    public synchronized void await() {

        while (count != this.total) {
            try {
                notifyAll();
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int getTotal() {
        return total;
    }

    public synchronized int getCount() {
        return count;
    }
}
