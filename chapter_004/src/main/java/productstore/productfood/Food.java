package productstore.productfood;

import java.time.LocalDate;

abstract public class Food {

    /**
     * name specific food.
     */
    String name;

    /**
     * field of date end expiration  period.
     */
    final LocalDate expirationDate;

    /**
     * price of item.
     */
    int price;

    /**
     * field date when item was made.
     */
    final LocalDate createDate;

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


    abstract public void setPrice(int price);

    abstract public String getName();

    abstract public LocalDate getExpirationDate();

    abstract public LocalDate getCreateDate();

    abstract public int getPrice();


    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    public String getNameStock() {
        return nameStock;
    }
}
