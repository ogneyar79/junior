package productstore.controlqualityheker;

import productstore.productfood.Food;
import productstore.dispatcherproduct.SuperStorageMap;

import java.time.LocalDate;


/**
 * Class is implementation of interface IControllQuality that check  quality of Goods at comparing with expiration date
 * and necessity transfer to specific warehouse at our case to Trash. if more than expiration date.
 */
public class ChekerTrashBinTime implements IControllQuality {

    /**
     * Field superStorageMap SuperStorageMap abstract class.
     */
    private SuperStorageMap superStorageMap;

    /**
     * Field show us where we going to transfer our Food food and necessity of what we check.
     * usually we set this destination stock from SuperStorageMap where get list of keys with name of Stock.
     */
    private String nameDestinationStorage;

    /**
     * Creator where we give the opportunity to select nameDestinationStorage.
     */
    public ChekerTrashBinTime(String nameDestinationStorage) {
        this.nameDestinationStorage = nameDestinationStorage;
    }

    /**
     * Creator where we set field nameDestinationStorage from superStorageMap on Specific storage wareHouse.
     *
     * @param superStorageMap SuperStorageMap.
     */
    public ChekerTrashBinTime(SuperStorageMap superStorageMap) {
        this.superStorageMap = superStorageMap;
        this.nameDestinationStorage = this.superStorageMap.getCommands().get(3);
    }

    /**
     * Function  that check  quality of Goods at comparing with expiration date
     * if more than  expiration period, that signal set True
     * and  need set  appropriate transfer place.
     * default we can set this by nameDestinationStorage.
     * If item situated in the same place that destination signal false.
     *
     * @param food Food, product implementation abstract class Food that we check.
     * @return result boolean.
     */
    @Override
    public boolean checkToSend(Food food) {
        boolean result = false;
        if (food.getNameStock().equals(nameDestinationStorage)) {
            return false;
        }
        LocalDate dayNow = LocalDate.now();
        if (dayNow.isAfter(food.getExpirationDate()) || dayNow.isEqual(food.getExpirationDate())) {
            result = true;
        }
        return result;
    }

    /**
     * Function clone public boolean checkToSend(Food food),
     * but add opportunity change local variable dayNow fore testing.
     *
     * @param food
     * @param daysPlus change local control date.
     * @return result bolean
     */
    public boolean checkToSendFortest(Food food, long daysPlus) {
        boolean result = false;
        if (food.getNameStock().equals(nameDestinationStorage)) {
            return false;
        }
        LocalDate dayNow = LocalDate.now().plusDays(daysPlus);

        System.out.println(dayNow);
        if (dayNow.isAfter(food.getExpirationDate())) {
            result = true;
        }
        return result;
    }

    @Override
    public SuperStorageMap get() {
        return this.superStorageMap;
    }

    @Override
    public String getNameDestinationS() {
        return this.nameDestinationStorage;
    }
}
