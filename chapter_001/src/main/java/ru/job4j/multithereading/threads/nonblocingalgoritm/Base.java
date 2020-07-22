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
        ++version;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Base base = (Base) o;

        if (id != base.id) return false;
        return version == base.version;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + version;
        return result;
    }
}
