package concurrent.userstorage;

public interface IUserStorage {


    boolean add(UserC user);

    boolean update(UserC user);

    boolean delete(UserC user);

    boolean transfer(int fromId, int toId, int amount);

}
