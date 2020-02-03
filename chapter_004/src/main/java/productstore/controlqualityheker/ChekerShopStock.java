package productstore.controlqualityheker;

import productstore.productfood.Food;
import productstore.dispatcherproduct.SuperStorageMap;

import java.time.LocalDate;

/**
 * Class is implementation of interface IControllQuality that check  quality of Goods
 * at comparing with expiration date and necessity transfer to specific warehouse at our case to Shop.
 * if more than 25% than Creation date but less than 75 % from creation (or 25 before expiration).
 */
public class ChekerShopStock implements IControllQuality {

    /**
     * Field show us where we going to transfer our Food food and necessity of what we check.
     * usually we set this destination stock from SuperStorageMap where get list of keys with name of Stock.
     */
    private String nameDestinationStorage;

    /**
     * Field superStorage SuperStorageMap abstract class.
     */
    private SuperStorageMap superStorage;

    /**
     * Creator where we give the opportunity to select nameDestinationStorage.
     */
    public ChekerShopStock(String nameDestinationStorage, SuperStorageMap superStorage) {
        this.nameDestinationStorage = nameDestinationStorage;
        this.superStorage = superStorage;
    }

    /**
     * Creator where we set field nameDestinationStorage from superStorage on Specific storage wareHouse.
     *
     * @param superStorage SuperStorageMap.
     */
    public ChekerShopStock(SuperStorageMap superStorage) {
        this.superStorage = superStorage;
        this.nameDestinationStorage = this.superStorage.getCommands().get(2);
    }

    /**
     * Function  that check  quality of Goods at comparing with expiration date and Creation date.
     * if more than 25 percent from beginning expiration period,  and less 25 from expiration.
     * that signal set True and  need set  appropriate transfer place.
     * default we can set this by nameDestinationStorage.
     * If item situated in the same place that destination signal false.
     *
     * @param food Food, product implementation abstract class Food that we check.
     * @return result boolean.
     */
    @Override
    public boolean checkToSend(Food food) {
        if (food.getNameStock().equals(this.nameDestinationStorage)) {
            return false;
        }
        boolean result = false;
        byte percent = 25;
        int differenceDay = new CalculatingExpirationRange().getExpirationDays(food);
        LocalDate dayNow = LocalDate.now();
        double resultPercentAtdays = (differenceDay * 0.01) * percent;
        if (new ShopCheckerSimple(resultPercentAtdays, food).checkAndCompare(dayNow)) {
            result = true;
        }
        return result;
    }

    /**
     * Class is implementation of interface ISimpleChekerBoolean for compare Local date that is now with Expiration period.
     * Here we set terms for compare and check it.
     */
    private class ShopCheckerSimple implements ISimpleChekerBoolean {
        final Food food;
        final double resultPercentAtdays;

        /**
         * Constructor default.
         *
         * @param resultPercentAtdays how much percent at the days from preset date we going to use.
         * @param food                Food
         */
        private ShopCheckerSimple(double resultPercentAtdays, Food food) {
            this.resultPercentAtdays = resultPercentAtdays;
            this.food = food;
        }

        /**
         * Function  compare LocalDate dateNow ,percent from date creation and date expiration.
         * if between preset range is true.
         *
         * @param dateNow LocalDate
         * @return result boolean
         */
        @Override
        public boolean checkAndCompare(LocalDate dateNow) {
            boolean result = false;
            if (dateNow.isBefore(food.getExpirationDate().minusDays((long) resultPercentAtdays)) && (dateNow.isAfter(food.getCreateDate().plusDays((long) resultPercentAtdays))) || (dateNow.isEqual(food.getCreateDate().plusDays((long) resultPercentAtdays)))) {
                result = true;
            }
            return result;
        }
    }

    @Override
    public SuperStorageMap get() {
        return this.superStorage;
    }

    @Override
    public String getNameDestinationS() {
        return this.nameDestinationStorage;
    }
}
