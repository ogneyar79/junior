package paking.manageparking;

import org.junit.Before;
import org.junit.Test;
import paking.car.Car;
import paking.car.Track;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyParkingTest {

    MyParking myParking;
    GroupPlaceCar placesCar;
    GroupPlaceTrack placesTrack;
    PlaceAbstract creatorCarPlace;
    PlaceAbstract creatorTrackPlace;

    int numberP = 8;
    Car car = new Car("LightCar", (byte) 3, 00);

    Car carOne = new Car("LightCar", (byte) 3, 01);
    Car carTwo = new Car("LightCar", (byte) 3, 02);
    Car carThree = new Car("LightCar", (byte) 3, 03);
    Car carFour = new Car("LightCar", (byte) 3, 04);

    Track track = new Track("Track", (byte) 5, 000);
    Track trackOne = new Track("Track", (byte) 5, 001);
    Track trackTwo = new Track("Track", (byte) 5, 002);
    Track trackThree = new Track("Track", (byte) 5, 003);
    Track trackFour = new Track("Track", (byte) 5, 004);
    Track trackFive = new Track("Track", (byte) 5, 005);
    Track trackSix = new Track("Track", (byte) 5, 006);
    Track trackSeven = new Track("Track", (byte) 5, 007);


    @Before
    public void setUp() throws Exception {
        creatorCarPlace = new PlaceCar(77);
        creatorTrackPlace = new PlaceTruck(88);
        placesCar = new GroupPlaceCar(numberP, creatorCarPlace);
        placesTrack = new GroupPlaceTrack(numberP, creatorTrackPlace);
        placesTrack.createGroupPlace(numberP);    //Think use this method at inner constructor Class
        placesCar.createGroupPlace(numberP);            // Think use this method at inner constructor Class
        myParking = new MyParking(placesCar, placesTrack); // object where parking our car


    }

    ///  @Test
//    public void findFeePlace() {
//        myParking.findFreePlace();
//    }

    @Test
    public void park() throws Exception, MyParking.MyException {
        myParking.park(car);
        System.out.println(myParking.getPlacesCar().countFreePlace());
        assertThat(myParking.getPlacesCar().countFreePlace(), is(7));
    }

    @Test
    public void parkWhenTrackParkFullButHaveFreeNearCarLightPlace() throws Exception, MyParking.MyException {
        myParking.park(car);
        Track trackEight = new Track("Track", (byte) 5, 888);
        System.out.println(myParking.getPlacesCar().countFreePlace());
        myParking.getPlacesCar().getPlace(0).occupyPlace(car);
        myParking.getPlacesTrack().getPlace(0).occupyPlace(track);
        myParking.getPlacesTrack().getPlace(1).occupyPlace(trackOne);
        myParking.getPlacesTrack().getPlace(2).occupyPlace(trackTwo);
        myParking.getPlacesTrack().getPlace(3).occupyPlace(trackThree);
        myParking.getPlacesTrack().getPlace(4).occupyPlace(trackFour);
        myParking.getPlacesTrack().getPlace(5).occupyPlace(trackFive);
        myParking.getPlacesTrack().getPlace(6).occupyPlace(trackSix);
        myParking.getPlacesTrack().getPlace(7).occupyPlace(trackSeven);
        myParking.park(trackEight);
        assertThat(myParking.getPlacesTrack().countFreePlace(), is(0));
        assertThat(myParking.getPlacesCar().countFreePlace(), is(5));

    }

//    @Test
//    public void getFreePlace() throws Exception, MyParking.MyException {
//        myParking.park(car);
//         System.out.println(myParking.getPlacesCar().countFreePlace());
//        System.out.println(myParking.getPlacesTrack().countFreePlace());
//
//        myParking.getFreePlace();  We make our  EXeption .MyParking$MyException
//    }

    @Test
    public void returnFlag() throws Exception {

        myParking.getPlacesCar().getPlace(0).occupyPlace(car);
        myParking.getPlacesTrack().getPlace(0).occupyPlace(track);
        myParking.getPlacesTrack().getPlace(1).occupyPlace(trackOne);
        myParking.getPlacesTrack().getPlace(2).occupyPlace(trackTwo);
        myParking.getPlacesTrack().getPlace(3).occupyPlace(trackThree);
        myParking.getPlacesTrack().getPlace(4).occupyPlace(trackFour);
        myParking.getPlacesTrack().getPlace(5).occupyPlace(trackFive);
        myParking.getPlacesTrack().getPlace(6).occupyPlace(trackSix);
        myParking.getPlacesTrack().getPlace(7).occupyPlace(trackSeven);

        System.out.println(myParking.getPlacesCar().countFreePlace());
        System.out.println(myParking.getPlacesTrack().countFreePlace());
        assertThat(myParking.returnFlag(car), is(true));
        assertThat(myParking.returnFlag(track), is(false));
    }

}