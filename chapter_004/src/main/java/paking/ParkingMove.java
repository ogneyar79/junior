package paking;

public class ParkingMove implements IMovingCar {

    private final Place place;
    private final Car car;

    public ParkingMove(Place place, Car car) {
        this.place = place;
        this.car = car;
    }

    @Override
    public void move() {
        this.place.beingPlaceOcupaded(this.car);
    }
}
