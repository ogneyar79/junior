package concurrent.userstorage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ThreadSafe
public class UserStorage implements IUserStorage {


    @GuardedBy("this")
    private final Set<UserC> userList;

    public UserStorage(Set<UserC> userList) {
        this.userList = userList;
    }


//    public Set<UserC> getUserList() {
//        return userList;
//    }

    @Override
    public synchronized boolean add(UserC user) {
        return userList.add(user);
    }

    @Override
    public synchronized boolean update(UserC user) {
        boolean result = false;
        if (this.userList.contains(user)) {
            userList.remove(user);
            result = userList.add(user);
        }
        return result;
    }

    @Override
    public synchronized boolean delete(UserC user) {

        return userList.remove(user);
    }

    @Override
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = true;
        List<UserC> list = this.userList.stream().filter(userC -> userC.getId() == fromId || userC.getId() == toId).collect(Collectors.toList());
        if (list.size() != 2) {
            return false;
        }
        for (UserC user : list) {
            if (user.getId() == fromId) {
                int res = user.getAmount() - amount;
                if (res < 0) {
                    return false;
                }
                user.setAmount(res);
            }
            if (user.getId() == toId) {
                user.setAmount(user.getAmount() + amount);
            }
        }
        return result;
    }

    public UserC getUserId(int id) {
        Optional<UserC> optionalUser = userList.stream().filter(userC -> userC.getId() == id).findAny();
        return optionalUser.isPresent() ? optionalUser.get() : new UserC(0, 0);

    }
}
