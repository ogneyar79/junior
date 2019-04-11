package ru.job4j.multithereading.threads.nonblocingalgoritm;

public class Base {


    /**
     * прееменная id object.
     */
    int id;

    /**
     * прееменная которая показывает версию нашего объекта.
     */
    int version;


    public Base(int id, int version) {
        this.id = id;
        this.version = version;
    }

    /**
     * метод изменяющий версию объекта на 1.
     */
    public void ecriment() {
        version++;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }
}
