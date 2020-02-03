package productstore.productfood;

import productstore.productfood.Food;

import java.time.LocalDate;

public class Fish extends Food {


    public Fish(final String name, long daysPlus, int price) {
        super(name, daysPlus, price);
    }

    /**
     * procedure where we set price out item.
     *
     * @param price
     */
    @Override
    public void setPrice(int price) {
        this.price = price;

    }

    /**
     * Function where we gen name our item.
     *
     * @return name String
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Function kind getter.
     *
     * @return expirationDate expiration Date
     */
    @Override
    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public LocalDate getCreateDate() {
        return this.createDate;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

}
