package productstore;

import org.junit.Before;
import org.junit.Test;
import productstore.dispatcherproduct.PostmanAnyStock;
import productstore.productfood.Fish;
import productstore.productfood.Food;
import productstore.superstorage.SuperStorage;
import productstore.superstorage.Warehouse;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PostmanAnyStockTest {

    SuperStorage superStorage;
    PostmanAnyStock postmanAnyStock;
    Food food;

    @Before
    public void setUp() throws Exception {
        superStorage = new Warehouse("1");
        postmanAnyStock = new PostmanAnyStock();
        postmanAnyStock.setSuperStorage(superStorage);
        food = new Fish("Shark", 10, 500);
    }

    @Test
    public void send() throws Exception {
        System.out.println(superStorage.getNameNumber());
        System.out.println(superStorage.getListProducts().size());
        assertThat(superStorage.getListProducts().size(), is(0));
        postmanAnyStock.send(food);
        assertThat(superStorage.getListProducts().size(), is(1));
    }

}