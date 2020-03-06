package paking.manageparking;

import org.junit.Before;
import org.junit.Test;
import paking.car.Car;
import paking.car.Track;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AGroupPlaceVehicleTest {
    AGroupPlaceVehicle groupPlaceVehicle;
    int numberPlace;
    AGroupPlaceVehicle trackGroup;

    PlaceAbstract<Car> carPlace = new PlaceCar(111);
    PlaceAbstract<Track> trackPlace = new PlaceCar(222);

    @Before
    public void setUp() throws Exception {
        numberPlace = 8;
        groupPlaceVehicle = new GroupPlaceCar(numberPlace, carPlace);
        trackGroup = new GroupPlaceTrack(numberPlace, trackPlace);
    }

    @Test
    public void createGroupPlace() throws Exception {
    //    groupPlaceVehicle.createGroupPlace(numberPlace);
        System.out.println(groupPlaceVehicle.getPlaceParcingsArray().length);
        System.out.println(groupPlaceVehicle.getType());
        PlaceAbstract placeCarOne = (PlaceAbstract) groupPlaceVehicle.getPlace(0);
        PlaceAbstract placeCarTwo = (PlaceAbstract) groupPlaceVehicle.getPlace(1);
        System.out.println(placeCarOne.getNumber());
        assertThat(placeCarOne.getNumber() == 1, is(true));
        assertThat(placeCarTwo.getNumber() == 2, is(true));
    }



    @Test
    public void getPlaceParcingsArray() throws Exception {
    }

    @Test
    public void countFreePlace() throws Exception {
        Car car = new Car("Light", (byte) 3,01);
        Car carOne = new Car("Light", (byte) 3,02);
      //  groupPlaceVehicle.createGroupPlace(numberPlace);
        System.out.println(groupPlaceVehicle.getPlaceParcingsArray().length);
        System.out.println(groupPlaceVehicle.countFreePlace());
        assertThat(numberPlace == groupPlaceVehicle.countFreePlace(), is(true));
        groupPlaceVehicle.getPlace(2).occupyPlace(car);
        System.out.println(groupPlaceVehicle.countFreePlace());
        groupPlaceVehicle.getPlace(4).occupyPlace(carOne);
        System.out.println(groupPlaceVehicle.countFreePlace());
        assertThat(groupPlaceVehicle.countFreePlace(), is(6));
        Track track = new Track("Track", (byte) 5,11);
        trackGroup.getPlace(3).occupyPlace(track);
        assertThat(trackGroup.countFreePlace(), is(7));
    }

}