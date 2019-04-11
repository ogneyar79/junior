package ru.job4j.multithereading.threads.safedinamiclist;

import ru.job4j.collection.list.DinamicArrayConteiner;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Iterator;

@ThreadSafe
public class ThreadSafeDinamicList<T> implements Iterable<T> {

    @GuardedBy("this")
    DinamicArrayConteiner<T> safeArray;


    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.safeArray).iterator();
    }

    private DinamicArrayConteiner<T> copy(DinamicArrayConteiner<T> safeArray) {
        DinamicArrayConteiner<T> snapshot = new DinamicArrayConteiner<>();
        Object[] container = safeArray.getContainer();
        snapshot.setContainer(container.clone());
        return snapshot;
    }
}
