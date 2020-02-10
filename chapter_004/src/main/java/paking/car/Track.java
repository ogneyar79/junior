package paking.car;

public class Track extends Vehicle {

    public Track(String tipe, byte size, int id) {
        super(tipe, size, id);
    }

    @Override
    public void move(IMovingVehicle car) {
        car.move(this);
    }

}
