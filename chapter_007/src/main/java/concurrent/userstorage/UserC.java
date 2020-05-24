package concurrent.userstorage;

import java.util.Objects;

public class UserC {

   private int id;

   private int amount;

    public UserC(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserC userC = (UserC) o;
        return id == userC.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
