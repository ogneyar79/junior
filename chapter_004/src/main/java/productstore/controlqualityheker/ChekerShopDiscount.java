package productstore.controlqualityheker;

import productstore.productfood.Food;
import productstore.dispatcherproduct.SuperStorageMap;

import java.time.LocalDate;

public class ChekerShopDiscount implements IControllQuality {

    /**
     * Field show us where we going to transfer our Food food and necessity of what we check.
     * usually we set this destination stock from SuperStorageMap where get list of keys with name of Stock.
     */
    private String nameDestinationS;

    /**
     * Field superStorageMap SuperStorageMap abstract class.
     */
    private SuperStorageMap superStorageMap;

    /**
     * field that set discount we want at currency.
     */
    int discount;

    /**
     * Procedure that set discount on concrete example of food.
     *
     * @param concreteFood Food abstract class.
     * @param discount     int at currency that we use.
     */
    void turnOnDiscount(Food concreteFood, int discount) {
        concreteFood.setPrice(concreteFood.getPrice() - discount);
    }

    /**
     * Creator where we set field nameDestinationS from superStorageMap on Specific storage wareHouse.
     *
     * @param nameDestinationS String here we set stock where we are going to transfer our item.
     * @param discount         int at how much currency you want discount price of.
     */
    public ChekerShopDiscount(String nameDestinationS, int discount) {
        this.nameDestinationS = nameDestinationS;
        this.discount = discount;
    }

    /**
     * Creator where we set field nameDestinationS from superStorageMap on Specific storage wareHouse default.
     *
     * @param superStorageMap SuperStorageMap.
     * @param discount        int at how much currency you want discount price of.
     */
    public ChekerShopDiscount(SuperStorageMap superStorageMap, int discount) {
        this.superStorageMap = superStorageMap;
        this.nameDestinationS = this.superStorageMap.getCommands().get(2);
        this.discount = discount;
    }

    /**
     * Function  that check  quality of Goods at comparing with expiration date
     * if less than 25 percent until end of expiration period, that signal set True
     * and  need set  appropriate transfer place also we set discount of the price.
     * default we can set this by nameDestinationS.
     * If item situated in the same place that destination signal false.
     *
     * @param food Food, product implementation abstract class Food that we check.
     * @return result boolean.
     */
    @Override
    public boolean checkToSend(Food food) {
        boolean result = false;
        byte percent = 25;

        int differenceDay = new CalculatingExpirationRange().getExpirationDays(food);

        double percentAtDays = (differenceDay * 0.01) * percent;
        LocalDate dayNow = LocalDate.now();
        if ((new CheckerSimple(food, percentAtDays).checkAndCompare(dayNow)) && !(food.getNameStock().equals(this.nameDestinationS))) {
            this.turnOnDiscount(food, this.discount);
            result = true;
        } else if ((new CheckerSimple(food, percentAtDays).checkAndCompare(dayNow)) && (food.getNameStock().equals(this.nameDestinationS))) {
            this.turnOnDiscount(food, this.discount);
            result = false;
        }
        return result;
    }

    /**
     * Class is implementation of interface ISimpleChekerBoolean for compare Local date that is now with Expiration period.
     * Here we set terms for compare and check it.
     */
    private class CheckerSimple implements ISimpleChekerBoolean {
        final Food food;
        final double percentAtDays;

        /**
         * Constructor default.
         *
         * @param percentAtDays how much percent at the days from preset date we going to use.
         * @param food          Food
         */
        CheckerSimple(Food food, double percentAtDays) {
            this.food = food;
            this.percentAtDays = percentAtDays;
        }

        @Override
        public boolean checkAndCompare(LocalDate dateNow) {
            boolean result = false;
            LocalDate expirationD = food.getExpirationDate();
            if (!(dateNow.isAfter(expirationD) || dateNow.isEqual(expirationD))) {
                if ((dateNow.isAfter(expirationD.minusDays((long) percentAtDays)) || dateNow.isEqual(expirationD.minusDays((long) percentAtDays)))) {
                    result = true;
                }
            }
            return result;
        }
    }

    /**
     * Function clone public boolean checkToSend(Food food),
     * but add opportunity change local variable dayNow fore testing.
     *
     * @param food
     * @param daysPlus change local control date.
     * @return result bolean
     */
    public boolean checkToSendForTest(Food food, long daysPlus) {

        boolean result = false;
        byte percent = 25;

        int differenceDay = new CalculatingExpirationRange().getExpirationDays(food);
        double percentAtDays = (differenceDay * 0.01) * percent;
        LocalDate dayNow = LocalDate.now().plusDays(daysPlus);

        System.out.println("Day now" + " " + dayNow);
        System.out.println("25 % at the days (this days we minus from expiration date)" + " " + percentAtDays);
        System.out.println(food.getExpirationDate().minusDays((long) percentAtDays));

        if ((new CheckerSimple(food, percentAtDays).checkAndCompare(dayNow)) && !(food.getNameStock().equals(this.nameDestinationS))) {
            this.turnOnDiscount(food, this.discount);
            result = true;
        } else if ((new CheckerSimple(food, percentAtDays).checkAndCompare(dayNow)) && (food.getNameStock().equals(this.nameDestinationS))) {
            this.turnOnDiscount(food, this.discount);
            result = false;
        }
        return result;
    }

    @Override
    public SuperStorageMap get() {
        return this.superStorageMap;
    }


    @Override
    public String getNameDestinationS() {
        return this.nameDestinationS;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
