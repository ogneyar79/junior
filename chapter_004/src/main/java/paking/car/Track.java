package paking.car;

public class Track extends Vehicle {

    public Track(final String type, byte size, int id) {
        super(type, size, id);
    }


    // need use constructor with one parameters at IMovingVehicle car
    @Override
    public void move(IMovingVehicle car) {
        car.move(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
