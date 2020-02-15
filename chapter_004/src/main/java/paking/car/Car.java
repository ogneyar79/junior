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

    public Car(String tipe, byte size, int id) {
        super(tipe, size, id);
    }


    // need use consructor with two parameters at IMovingVehicle type one of them parking and yourself Car
    @Override
    public void move(IMovingVehicle type) {
        type.move();

    }
}
