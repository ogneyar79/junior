package concurrent;

import java.util.ArrayList;

public class ThreadSleep {

    static ArrayList<String> arrayList = new ArrayList<>();


    public static void main(String[] args) {
        arrayList.add(" Victor");
        arrayList.add("Maksimus");
        arrayList.add(" Vasilio");
        arrayList.add("Maksim");
        arrayList.add("Maks");
        arrayList.add("RU");

        Thread thread = new Thread(
                () -> {
                    try {
                        System.out.println("Start loading ... ");
                        Thread.sleep(3000);
                        arrayList.stream().filter(x -> {
                              System.out.println(x);
                            return x.length() > 4;
                        });
                                //.forEach(System.out::println);

                        System.out.println("Loaded.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
        System.out.println("Main");
    }


}
