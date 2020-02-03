package productstore.dispatcherproduct;

import productstore.productfood.Food;
import productstore.superstorage.SuperStorage;

public class PostmanAnyStock implements IPostmanSending {

    SuperStorage superStorage;


    @Override
    public void setSuperStorage(SuperStorage superStorage) {
        this.superStorage = superStorage;
    }

    @Override
    public void send(Food food) {
        this.superStorage.insert(food);
    }

    @Override
    public IPostmanSending getThisNewObject() {
       return new PostmanAnyStock();
    }

}
