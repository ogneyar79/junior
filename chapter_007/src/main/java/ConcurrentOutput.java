public class ConcurrentOutput {

    public static void main(String[] args) throws InterruptedException {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        another.start();
  //      another.join(006);
        System.out.println(Thread.currentThread().getName());

        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        second.start();
    }}
