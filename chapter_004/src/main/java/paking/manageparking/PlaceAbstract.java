package paking.manageparking;

import paking.car.IVehicle;


import java.util.ArrayList;


/**
 * Class for mapping concrete cell for parking(parking place) for different type Vehicle.
 */
abstract public class PlaceAbstract<T extends IVehicle> implements IPlaceParking {


    /**
     * field show us free parking place or not.
     */
    private boolean free = true;

    /**
     * field always array with one length for keeping parking vehicleList
     */
    private final ArrayList<T> vehicleList;

    final int number;

    public int getNumber() {
        return number;
    }

    public PlaceAbstract(int number, byte size) {
        this.number = number;
        this.size = size;
        this.vehicleList = new ArrayList<>(1);
        System.out.println(vehicleList.size() + " SIZE");
    }

    abstract public PlaceAbstract createNewInstance(int number);

    /**
     * field show size of our parking cell
     */
    private byte size;

    public void setSize(byte size) {
        this.size = size;
    }

    public void setFree(boolean freeOrNo) {
        this.free = freeOrNo;
    }

    public boolean isFree() {
        return free;
    }


    public byte getSize() {
        return size;
    }

    public void occupyPlace(IVehicle car) {
        this.vehicleList.add ((T) car);
        this.setFree(false);
    }

    public IVehicle makePlaceFree() {
        IVehicle vehicle = vehicleList.remove(0);
        this.setFree(true);
        return vehicle;

    }

    public ArrayList<T> getVehicleList() {
        return vehicleList;
    }

    public T getPlace() {
        return this.getVehicleList().get(0);
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
