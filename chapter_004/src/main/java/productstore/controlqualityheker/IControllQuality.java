package productstore.controlqualityheker;

import productstore.productfood.Food;
import productstore.dispatcherproduct.SuperStorageMap;

public interface IControllQuality {


    boolean checkToSend(Food food);

    SuperStorageMap get();

    String getNameDestinationS();

}
