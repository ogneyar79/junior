package productstore.superstorage;

import productstore.productfood.Food;

import java.util.List;

public class Warehouse extends SuperStorage {


    public Warehouse(String nameNumber) {
        super(nameNumber);
    }

    @Override
    public List<Food> getListProducts() {
        return this.listProducts;
    }
}
