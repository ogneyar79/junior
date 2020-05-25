package concurrent.userstorage;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.Is.*;

public class SingleLockListTest {

    @Test
    public void add() throws InterruptedException {
        SingleLockList<Integer> list = new SingleLockList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iteratorFirst = list.iterator();
        list.add(4);
        list.add(5);

        int result = 0;
        while (iteratorFirst.hasNext()) {
            iteratorFirst.next();
            result++;
        }
        assertThat(result, is(3));
    }
}