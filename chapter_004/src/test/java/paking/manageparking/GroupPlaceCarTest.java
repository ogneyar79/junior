package paking.manageparking;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GroupPlaceCarTest {

    GroupPlaceCar carGroop;
    PlaceCar placeCar;
    ArrayList<PlaceCar> placeList;

    @Before
    public void setUp() throws Exception {
        placeCar = new PlaceCar(12);
        carGroop = new GroupPlaceCar(5, placeCar);
        carGroop.createGroupPlace(5);
    }

    @Test
    public void findNearFreePlace() throws Exception {
        placeList = carGroop.findNearFreePlace();
        PlaceCar car1 = placeList.get(0);
        PlaceCar car2 = placeList.get(1);
        System.out.println(placeList.size());
        System.out.println(car1.getNumber());
        System.out.println(car2.getNumber());
        assertThat(car1.getNumber(), is(1));
        assertThat(car2.getNumber(), is(2));
    }

}