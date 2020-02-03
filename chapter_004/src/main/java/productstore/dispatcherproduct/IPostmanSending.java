package productstore.dispatcherproduct;

import productstore.productfood.Food;
import productstore.superstorage.SuperStorage;

public interface IPostmanSending {

    public void setSuperStorage(SuperStorage superStorage);

    public void send(Food food);

    public IPostmanSending getThisNewObject();

}
