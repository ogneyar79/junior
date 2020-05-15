package concurrent;

public class ConsoleProgress implements Runnable {
    String pro = " ";

    String changePro() {

        if (pro.equalsIgnoreCase(" - ")) {
            this.pro = " \\ ";
            return pro;
        }
        if (pro.equalsIgnoreCase(" \\ ")) {
            this.pro = " | ";
            return pro;
        }
        if (pro.equalsIgnoreCase(" | ")) {
            this.pro = " / ";
            return pro;
        }

        this.pro = " - ";
        return this.pro;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(500);
                System.out.print("\r load: " + changePro());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(1);
        progress.interrupt();

    }
}
