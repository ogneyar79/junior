package ru.job4j.collection.statistickollection;

import java.util.List;

public class Store {

    /**
     * информируют объект о количестве добавленных и удалленнх, измененных элементов путем сравнения двух коллекций, внутри используется HashMap.
     *
     * @param previoues предыдущая коллекция.
     * @param current   текущая коллекция
     * @return infoObject возвращаемый List объект.
     */
    List<List<String>> diff(List<User> previoues, List<User> current) {
        InfoWithHashMap infoObject = new InfoWithHashMap();

        return infoObject.infoChangeOfcollectiont(previoues, current);
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;

            if (id != user.id) {
                return false;
            }
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }


}
