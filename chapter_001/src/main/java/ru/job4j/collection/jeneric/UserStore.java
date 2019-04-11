package ru.job4j.collection.jeneric;

public class UserStore<T extends Base> extends AbstractStore {
    public UserStore(SimpleArray userOrRoleArray) {
        super(userOrRoleArray);
    }
}
