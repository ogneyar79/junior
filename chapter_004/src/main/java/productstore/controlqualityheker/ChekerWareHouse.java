package productstore.controlqualityheker;

import productstore.productfood.Food;
import productstore.dispatcherproduct.SuperStorageMap;

import java.time.LocalDate;

/**
 * Class is implementation of interface IControllQuality that check  quality of Goods at comparing with expiration date
 * and necessity transfer to specific warehouse at our case to WareHouse.
 * if less than 25% than creation date.
 */
public class ChekerWareHouse implements IControllQuality {

    /**
     * Field superStorageMap SuperStorageMap abstract class.
     */
    private SuperStorageMap superStorageMap;

    /**
     * Field show us where we going to transfer our Food food and necessity of what we check.
     * usually we set this destination stock from SuperStorageMap where get list of keys with name of Stock.
     */
    private String nameDestinationS;

    /**
     * Creator where we give the opportunity to select nameDestinationS.
     */
    public ChekerWareHouse(SuperStorageMap superStorageMap, String nameDestinationS) {
        this.superStorageMap = superStorageMap;
        this.nameDestinationS = nameDestinationS;
    }

    /**
     * Creator where we set field nameDestinationS from superStorageMap on Specific storage wareHouse.
     *
     * @param superStorageMap SuperStorageMap.
     */
    public ChekerWareHouse(SuperStorageMap superStorageMap) {
        this.superStorageMap = superStorageMap;
        this.nameDestinationS = this.superStorageMap.getCommands().get(0);
    }

    /**
     * Function  that check  quality of Goods at comparing with expiration date
     * if less than 25 percent from beginning expiration period, that signal set True
     * and  need set  appropriate transfer place.
     * default we can set this by nameDestinationS.
     * If item situated in the same place that destination signal false.
     *
     * @param food Food, product implementation abstract class Food that we check.
     * @return result boolean.
     */
    @Override
    public boolean checkToSend(Food food) {

        if (food.getNameStock().equals(nameDestinationS)) {
            return false;
        }
        byte percent = 25;

        int differenceDay = new CalculatingExpirationRange().getExpirationDays(food);
        double resultPercentAtDays = (differenceDay * 0.01) * percent;
        LocalDate dayNow = LocalDate.now();
        boolean result = (dayNow.isBefore(food.getCreateDate().plusDays((long) resultPercentAtDays))) ? true : false;
        return result;
    }

    @Override
    public SuperStorageMap get() {
        return this.superStorageMap;
    }

    public SuperStorageMap getSuperStorageMap() {
        return superStorageMap;
    }

    public String getNameDestinationS() {
        return nameDestinationS;
    }

    public void setSuperStorageMap(SuperStorageMap superStorageMap) {
        this.superStorageMap = superStorageMap;
    }

    public void setNameDestinationS(String nameDestinationS) {
        this.nameDestinationS = nameDestinationS;
    }
}
