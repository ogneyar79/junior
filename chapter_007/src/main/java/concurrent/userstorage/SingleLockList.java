package concurrent.userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.collection.list.DinamicArrayConteiner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    @GuardedBy("this")
    private DinamicArrayConteiner<T> list = new DinamicArrayConteiner();

    public synchronized void add(T value) {

        this.list.add(value);
    }

    public synchronized T get(int index) {
        return this.list.get(index);
    }

    public synchronized DinamicArrayConteiner<T> copy(DinamicArrayConteiner<T> list) {
        DinamicArrayConteiner copyList = new DinamicArrayConteiner();
        Arrays.stream(list.getContainer()).filter(Objects::nonNull).forEach(copyList::add);
        return copyList;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return this.copy(this.list).iterator();
    }

    public DinamicArrayConteiner<T> getList() {
        return list;
    }
}
