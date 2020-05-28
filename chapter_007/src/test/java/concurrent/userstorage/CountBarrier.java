package concurrent.userstorage;

public class CountBarrier {

    private final Object monitor = this;

    private int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public void count() {
        synchronized (monitor) {
            monitor.notify();
            this.count++;
        }
        total = this.count;


    }

    public void await() {

        while (count != this.total) {
            try {
                wait();
                monitor.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }
}
