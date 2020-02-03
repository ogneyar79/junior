package productstore;

import org.junit.Before;
import org.junit.Test;
import productstore.controlqualityheker.ChekerShopDiscount;
import productstore.controlqualityheker.IControllQuality;
import productstore.dispatcherproduct.SuperStorageMap;
import productstore.productfood.Fish;
import productstore.productfood.Food;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ChekerShopDiscountTest {

    Food food;

    SuperStorageMap superStorageMap = new SuperStorageMap();
    IControllQuality controllQuality;
    int discount;

    @Before
    public void setUp() throws Exception {
        discount = 300;
        food = new Fish("Shark", 10, 500);
        superStorageMap.initDefault();
    }

    @Test
    public void setDiscount() throws Exception {
        food.setNameStock("1");
        new ChekerShopDiscount(superStorageMap, discount).turnOnDiscount(food, discount);
        assertThat(food.getPrice(), is(200));
    }

    @Test
    public void checkToSend() throws Exception {
        food.setNameStock("1");
        controllQuality = new ChekerShopDiscount(superStorageMap, discount);
        boolean result = new ChekerShopDiscount(superStorageMap, discount).checkToSendForTest(food, 8);
        assertThat(food.getPrice(), is(200));
        assertThat(result, is(true));
    }

}