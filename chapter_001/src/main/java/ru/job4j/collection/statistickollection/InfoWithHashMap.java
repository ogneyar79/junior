package ru.job4j.collection.statistickollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoWithHashMap {

    /**
     * карта для сравнения колеций.
     */
    private HashMap<Integer, String> theCompareMap = new HashMap<>();

    /**
     * информируют объект о измененных и удаленных елементах в коллекции.
     *
     * @param previoues предыдущая коллекция.
     * @param current   текущая коллекция
     */
    public List<String> changedAndDeletedElments(List<Store.User> previoues, List<Store.User> current) {
        String info;
        List<String> listInfo = new ArrayList<>();
        int infoAbDeleletedElement = 0;
        int changedElement = 0;
        for (Store.User userC : current) {
            this.theCompareMap.putIfAbsent(userC.id, userC.name);
        }
        for (Store.User userP : previoues) {

            String userName;
            userName = this.theCompareMap.put(userP.id, userP.name);
            if (userName != null) {
                if (!userP.name.equals(userName)) {
                    changedElement++;
                    info = userP.name + "" + userP.id + "Was changed for " + userName;
                    listInfo.add(info);
                    this.theCompareMap.remove(userP.id);
                } else {
                    this.theCompareMap.remove(userP.id);
                }
            } else {
                info = "" + userP.id + "With" + userP.name + " was deleted";

                infoAbDeleletedElement++;
                listInfo.add(info);
                this.theCompareMap.remove(userP.id);
            }
        }
        info = changedElement + " " + " Elements Was changed";
        listInfo.add(info);
        info = infoAbDeleletedElement + " Elements Was deleted ";
        listInfo.add(info);
        return listInfo;
    }

    /**
     * информируют объект о добавленных эелементах.
     *
     * @param theCompareMap предыдущая коллекция.
     */
    private List<String> infoAboutAddedElement(HashMap<Integer, String> theCompareMap) {
        String info;
        List<String> listInfo = new ArrayList<>();
        info = theCompareMap.size() + "" + "Elements was added ";
        listInfo.add(info);
        for (Map.Entry<Integer, String> entryset : theCompareMap.entrySet()) {
            info = "" + entryset.getKey() + " " + "With" + entryset.getValue() + " " + "Was added";
            listInfo.add(info);
        }
        return listInfo;
    }

    /**
     * информируют объект о измениниях в коллекции.
     *
     * @param previoues предыдущая коллекция.
     * @param current   текущая коллекция
     */
    public List<List<String>> infoChangeOfcollectiont(List<Store.User> previoues, List<Store.User> current) {

        List<List<String>> listsInfo = new ArrayList<>();
        listsInfo.add(this.changedAndDeletedElments(previoues, current));
        listsInfo.add(this.infoAboutAddedElement(this.theCompareMap));
        return listsInfo;
    }

    public HashMap<Integer, String> getTheCompareMap() {
        return theCompareMap;
    }
}