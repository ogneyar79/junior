package ru.job4j.collection.jeneric;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray userOrRoleArray = new SimpleArray<T>();

    public AbstractStore(final SimpleArray userOrRoleArray) {
        this.userOrRoleArray = userOrRoleArray;
    }

    @Override
    public void add(T model) {
        userOrRoleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean doneReplacedIt = false;
        Iterator<T> simpleArrayIterator = userOrRoleArray.iterator();
        while (simpleArrayIterator.hasNext()) {
            int positionItBeforeNext = userOrRoleArray.getIndex();
            T wanted = simpleArrayIterator.next();
            if (wanted.getId().compareTo(id) == 0) {
                userOrRoleArray.set(positionItBeforeNext, model);
                doneReplacedIt = true;
                break;
            }
        }
        if (!doneReplacedIt) {
            System.out.println(" Check your String id, Might it's inccorect");
        }
        return doneReplacedIt;
    }

    @Override
    public boolean delete(String id) {
        boolean done = false;
        Iterator<T> simpleArrayIterator = userOrRoleArray.iterator();
        while (simpleArrayIterator.hasNext()) {
            int positionItBeforeNext = userOrRoleArray.getIndex();
            T wanted = simpleArrayIterator.next();
            if (wanted.getId().compareTo(id) == 0) {
                userOrRoleArray.delete(positionItBeforeNext);
                done = true;
                break;
            }
        }
        if (!done) {
            System.out.println(" Check your String id, Might it's inccorect");
        }
        return done;
    }
    @Override
    public T findById(String id) {
        Iterator<T> simpleArrayIterator = userOrRoleArray.iterator();
        while (simpleArrayIterator.hasNext()) {
            T wanted = simpleArrayIterator.next();
            if (wanted.getId().compareTo(id) == 0) {
                return wanted;
            }
        }
        return null;
    }
}

