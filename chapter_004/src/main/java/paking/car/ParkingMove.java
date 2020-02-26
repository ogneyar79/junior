package paking.car;


import paking.manageparking.IPlaceParking;


/**
 * class for make parking Vehicle.
 */
public class ParkingMove implements IMovingVehicle {

    private final IPlaceParking place;
    private Vehicle vehicle;

    public ParkingMove(IPlaceParking place, Vehicle vehicle) {
        this.place = place;
        this.vehicle = vehicle;
    }
    @Override
    public void move() {
        this.place.occupyPlace(this.vehicle);
    }


    public ParkingMove(IPlaceParking place) {
        this.place = place;

    }
    @Override
    public void move(IVehicle car) {

        this.place.occupyPlace(car);
    }




}
