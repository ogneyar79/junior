package productstore;

import org.junit.Before;
import org.junit.Test;
import productstore.controlqualityheker.ChekerTrashBinTime;
import productstore.controlqualityheker.IControllQuality;
import productstore.dispatcherproduct.SuperStorageMap;
import productstore.productfood.Fish;
import productstore.productfood.Food;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ChekerTrashBinTimeTest {
    Food food;

    SuperStorageMap superStorageMap = new SuperStorageMap();

    IControllQuality controlTrash;

    @Before
    public void setUp() throws Exception {
        food = new Fish("Shark", 10, 500);
        food.setNameStock("1");
        superStorageMap.initDefault();
        controlTrash = new ChekerTrashBinTime(superStorageMap);

    }

    @Test
    public void checkToSend() throws Exception {
        System.out.println(food.getName());
        System.out.println(food.getNameStock());
        System.out.println(controlTrash.getNameDestinationS());
        boolean result = new ChekerTrashBinTime(superStorageMap).checkToSendFortest(food, 11);
        assertThat(result, is(true));
    }

    @Test
    public void checkToSendWto() {
        System.out.println(food.getName());
        System.out.println(food.getNameStock());
        System.out.println(controlTrash.getNameDestinationS());
        boolean result = new ChekerTrashBinTime(superStorageMap).checkToSendFortest(food, 5);
        assertThat(result, is(false));
    }

}