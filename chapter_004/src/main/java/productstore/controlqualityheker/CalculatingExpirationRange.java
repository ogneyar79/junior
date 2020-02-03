package productstore.controlqualityheker;

import productstore.productfood.Food;

 class CalculatingExpirationRange {

    /**
     * Function that let's get us  Quantity of days between Creation date and Expiration date(Class LocalDaTe) our Food food.
     *
     * @param food
     * @return differenceDay int
     */
    public int getExpirationDays(Food food) {
        int differenceDay;              // period between Created date and Expiration date
        int dayCreatDay = food.getCreateDate().getDayOfMonth();
        int expaiereDay = food.getExpirationDate().getDayOfMonth();
        int monthFirst = food.getCreateDate().getMonthValue();
        int monthSecond = food.getExpirationDate().getMonthValue();
        if (monthFirst == monthSecond) {
            differenceDay = expaiereDay - dayCreatDay;
        } else {
            int lengthMonth = food.getCreateDate().lengthOfMonth();
            differenceDay = (lengthMonth - dayCreatDay) + expaiereDay;
        }
        return differenceDay;
    }

}
