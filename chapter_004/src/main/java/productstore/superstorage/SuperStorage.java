package productstore.superstorage;

import productstore.productfood.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class SuperStorage {
    List<Food> listProducts;
    String nameNumber;

    public SuperStorage(String nameNumber) {
        this.listProducts = new ArrayList<>();
        this.nameNumber = nameNumber;
    }

    public String getNameNumber() {
        return nameNumber;
    }

    public List<Food> getListProducts() {
        return this.listProducts;
    }

    public void insert(Food food) {
        food.setNameStock(this.nameNumber);
        this.listProducts.add(food);
    }
}
