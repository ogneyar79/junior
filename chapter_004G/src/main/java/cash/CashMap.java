package cash;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class CashMap<T, V> {

    T value;

    HashMap<T, SoftReference<T>> cashMap = new HashMap();

    public T get(T key) {
        SoftReference<T> softRef = this.cashMap.get(key);

        if (softRef == null) {
            return null;
        }

        return softRef.get();
    }


    public Object put(T key, T value) {
        SoftReference<T> softRef = this.cashMap.put(key, new SoftReference(value));

        if (softRef == null) {
            return null;
        }

        T oldValue = softRef.get();
        softRef.clear();

        return oldValue;
    }

    public T remove(T key) {
        SoftReference<T> softRef = this.cashMap.remove(key);

        if (softRef == null) {
            return null;
        }

        T oldValue = softRef.get();
        softRef.clear();

        return oldValue;
    }


}
