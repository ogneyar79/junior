package ru.job4j.collection.set;//package ru.job4j.collection.Set;
//
//import ru.job4j.collection.list.SimpleArrayList;
//
//import java.util.Iterator;
//
///**
// * set на базе связанного списка SimpleArrayList.
// * <p>
// * "param <E> Тип элемента в set
// */
//public class SimpleLinkedSet<E> implements Iterable<E> {
//
//    /**
//     * Наш контэйнер для хранения на основе связанного списка SimpleArrayList.
//     */
//    private SimpleArrayList<E> simpleLinkedSetcontainer = new SimpleArrayList();
//
//    /**
//     * метод проверки наличия заданного элемента.
//     *
//     * @param e проверяемы объект.
//     */
//    boolean checkEauals(E e) {
//        boolean result = false;
//        Iterator<E> simpleLinkedSetItetator = simpleLinkedSetcontainer.iterator();
//        while (simpleLinkedSetItetator.hasNext()) {
//            E content = simpleLinkedSetItetator.next();
//            if (content.equals(e)) {
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
//
//    /**
//     * Добавление элемнтов в set.
//     *
//     * @param element добавляемый объект
//     */
//    public void add(E element) {
//        if (!this.checkEauals(element)) {
//            simpleLinkedSetcontainer.add(element);
//        }
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return this.simpleLinkedSetcontainer.iterator();
//    }
//}
//