package paking.manageparking;

import org.junit.Before;
import org.junit.Test;
import paking.car.Car;
import paking.car.IVehicle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PlaceCarTest {
    PlaceAbstract placeAbstract;
    IVehicle car;

    IVehicle[] vehiclesC = new IVehicle[10];

    @Before
    public void setUp() throws Exception {
        car = new Car("L", (byte) 3, 01);
        vehiclesC[0] = car;
        placeAbstract = new PlaceCar(01);


    }

    @Test
    public void setPlaceFree() throws Exception {
        placeAbstract.occupyPlace(car);
        placeAbstract.makePlaceFree();
        assertThat(placeAbstract.getVehicleList().size(), is(0));
        assertThat(placeAbstract.isFree(), is(true));
    }

    @Test
    public void getVehicle() throws Exception {
        placeAbstract.occupyPlace(car);
        assertThat(placeAbstract.getVehicleList().size(), is(1));
    }

    @Test
    public void occupyPlace() throws Exception {
        placeAbstract.occupyPlace(car);
        assertThat(placeAbstract.getPlace(), is(car));
    }
}