package paking.car;

public class Car extends Vehicle {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Car(String type, byte size, int id) {
        super(type, size, id);
    }


    //  before need use consructor with two parameters at IMovingVehicle type one of them parking and yourself Car Now Like at track
    @Override
    public void move(IMovingVehicle type) {
        type.move(this);

    }
}
