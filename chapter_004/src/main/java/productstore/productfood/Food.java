package productstore.productfood;

import java.time.LocalDate;

abstract public class Food {

    /**
     * name specific food.
     */
    private String name;

    /**
     * field of date end expiration  period.
     */
    private final LocalDate expirationDate;

    /**
     * price of item.
     */
    private int price;

    /**
     * field date when item was made.
     */
    private final LocalDate createDate;

    /**
     * field that show where item located now.
     */
    private String nameStock = new String();

    /**
     * default constructor where set 4 parameters one of them(createDate) automatically.
     *
     * @param name     String.
     * @param daysPlus long how many days need to add to create day and as result get expiration date.
     * @param price    Int.
     */
    public Food(String name, long daysPlus, int price) {
        this.name = name;
        this.createDate = LocalDate.now();
        this.expirationDate = createDate.plusDays(daysPlus);
        this.price = price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public int getPrice() {
        return this.price;
    }


    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    public String getNameStock() {
        return nameStock;
    }
}
