package concurrent;

public class ThreadState {
    public static String getThreadsName() {
        String result;
        return result = " Thread's name" + " " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException {


        Thread first = new Thread(
                () -> {
                    System.out.println(getThreadsName() + " " + Thread.currentThread().getState());
                    System.out.println(getThreadsName() + " Finish");
                }
        );

        Thread second = new Thread(
                () -> {
                    System.out.println(getThreadsName() + " " + Thread.currentThread().getState());
                    System.out.println(getThreadsName() + " Finish");
                }
        );

        System.out.println(first.getState());
        System.out.println(second.getState());
        first.start();
        second.start();

        while (first.getState() != Thread.State.TERMINATED & second.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName() + " " + first.getState());
            System.out.println(second.getName() + " " + second.getState());
        }
        Thread.sleep(500);
        System.out.println("First" + " " + first.getState());
        System.out.println("Second" + " " + second.getState());
        System.out.println(getThreadsName() + " " + Thread.currentThread().getState());
        System.out.println(getThreadsName() + " After all  Main Finished");
    }

}
