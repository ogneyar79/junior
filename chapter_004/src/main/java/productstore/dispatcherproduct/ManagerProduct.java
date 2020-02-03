package productstore.dispatcherproduct;

import productstore.controlqualityheker.IControllQuality;
import productstore.productfood.Food;
import productstore.superstorage.SuperStorage;

import java.util.*;

/**
 * Class for manage with products control.
 */
public class ManagerProduct {

    /**
     * Field  object for keeping different implementation SuperStorage where keeping products.
     */
    SuperStorageMap superStorageMap = new SuperStorageMap();


    /**
     * Field interface objects for sending goods to different storage.
     */
    IPostmanSending postman;


    /**
     * Procedure for control quality products(expired date) and sending products(Food) to appropriate storage
     *
     * @param concreteFood Food.
     */
    public boolean distributeChecking(Food concreteFood, IPostmanSending postman) {
        ArrayList<IControllQuality> controlChekers = this.superStorageMap.getControllQualities();
        boolean result = false;
        for (IControllQuality cheker : controlChekers) {
            if (cheker.checkToSend(concreteFood)) {
                this.postman = postman.getThisNewObject();
                postman.setSuperStorage(this.superStorageMap.getSuperStorage().get(cheker.getNameDestinationS()));
                postman.send(concreteFood);
                result = true;
            }
        }
        return result;
    }

    /**
     * Procedure that move on our Stock(Shop itc), control quality and send  goods to appropriate Stock
     * and remove good from stock where it was before
     *
     * @param postman
     */
    public void movingControl(IPostmanSending postman) {
        for (Map.Entry<String, SuperStorage> entry : this.superStorageMap.getSuperStorage().entrySet()) {
            SuperStorage storage = entry.getValue();
            ListIterator<Food> stockFoodIterator = storage.getListProducts().listIterator();
            while (stockFoodIterator.hasNext()) {
                Food concreteFood = stockFoodIterator.next();
                if (this.distributeChecking(concreteFood, postman)) {
                    stockFoodIterator.remove();
                }
            }
        }
    }

}




