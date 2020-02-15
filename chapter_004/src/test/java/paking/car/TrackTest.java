package paking.car;

import org.junit.Before;
import org.junit.Test;
import paking.manageparking.PlaceAbstract;
import paking.manageparking.PlaceCar;
import paking.manageparking.PlaceTruck;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackTest {

    IMovingVehicle parkOfCar;
    PlaceAbstract placeParking;

    Track track = new Track("Track", (byte) 5, 02);

    @Before
    public void setUp() throws Exception {
        placeParking = new PlaceTruck(01);
        parkOfCar = new ParkingMove(placeParking);
    }

    @Test
    public void move() throws Exception {
        track.move(parkOfCar);
        placeParking.getPlace();
        assertThat(placeParking.getPlace(), is(track));

    }

}