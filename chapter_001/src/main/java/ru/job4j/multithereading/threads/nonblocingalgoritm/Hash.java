package ru.job4j.multithereading.threads.nonblocingalgoritm;

import java.util.concurrent.ConcurrentHashMap;

public class Hash {

    /**
     * Переменная ConcurrentHashMap где размещаются объекты.
     */
    ConcurrentHashMap<Integer, Base> mapBase = new ConcurrentHashMap<>();

    /**
     * Добавление элемнтов в Hash контейнер.
     *
     * @param model добавляемый объект
     */
    public void add(Base model) {
        this.mapBase.put(model.getId(), model);
    }

    /**
     * удаление объекта из контейнера.
     *
     * @param model удаляемый объект
     */
    public void delete(Base model) {
        mapBase.remove(model.getId());

    }

    /**
     * изменение объекта в нашем контейнере.
     *
     * @param modelA объект that we want to change if it is at map.
     */
    public void update(Base modelA) {

        this.mapBase.computeIfPresent(modelA.getId(), (key, value) -> {
            if (mapBase.get(key).getVersion() != modelA.version) {
                throw new OptimisticException(" It has already been changed");
            }
            value.ecriment();
            return value;
        });
    }
}
