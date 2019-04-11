package ru.job4j.collection.statistickollection;

import java.util.ArrayList;

public class Info {

    /**
     * показывает количество добавленных элеметов в коллекцию.
     */
    private int infoAboutNewAdded;

    /**
     * показывает количество удаленных элеметов в коллекции.
     */
    private int infoAbDeleletedElement;

    /**
     * показывает количество добавленных и удаленных элементов, и изменнных.
     */
    private java.util.List<String> listInfo = new ArrayList<>();

    private int changedElement = 0;

    /**
     * информируют объект о количестве добавленных и удалленнх элементов путем сравнения двух коллекций.
     *
     * @param previoues предыдущая коллекция.
     * @param current   текущая коллекция
     */
    public void makeInfoAboutAddadedElements(java.util.List<Store.User> previoues, java.util.List<Store.User> current) {
        String info;
        int sameElements = 0;
        for (Store.User userPr : previoues) {
            for (Store.User userCurrent : current) {
                if (userPr.id == userCurrent.id) {
                    sameElements++;
                }
            }
        }
        infoAbDeleletedElement = previoues.size() - sameElements;
        info = "" + infoAbDeleletedElement + "Was deleted";
        listInfo.add(info);
        infoAboutNewAdded = current.size() - sameElements;
        info = "" + infoAboutNewAdded + " Was added elemets";
        listInfo.add(info);
    }

    public void showChangedElement(java.util.List<Store.User> previoues, java.util.List<Store.User> current) {
        String info;
        for (Store.User userPr : previoues) {
            for (Store.User userCurrent : current) {
                if (userPr.id == userCurrent.id & !userPr.name.equals(userCurrent.name)) {
                    changedElement++;
                    info = " " + userPr.id + " " + "id Was changed";
                    listInfo.add(info);
                }
            }
        }
        info = " " + changedElement + " " + " Elements was changed";
        listInfo.add(info);
    }

    public int getInfoAboutNewAdded() {
        return infoAboutNewAdded;
    }

    public int getInfoAbDeleletedElement() {
        return infoAbDeleletedElement;
    }

    public java.util.List<String> getListInfo() {
        return listInfo;
    }

    public int getChangedElement() {
        return changedElement;
    }
}
