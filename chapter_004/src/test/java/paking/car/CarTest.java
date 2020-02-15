package paking.car;

import org.junit.Before;
import org.junit.Test;

import paking.manageparking.PlaceAbstract;
import paking.manageparking.PlaceCar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CarTest {

    Car car = new Car("L", (byte) 3, 01);
    IMovingVehicle parkOfCar;
    PlaceAbstract placeParking;

    @Before
    public void setUp() throws Exception {
        placeParking = new PlaceCar(01);
        // may be to delete parametr Car from comstructor?
        parkOfCar = new ParkingMove(placeParking, car);


    }

    @Test
    public void move() throws Exception {
        car.move(parkOfCar);
        placeParking.getPlace();
        assertThat(placeParking.getPlace(), is(car));
    }


}