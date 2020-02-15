package paking.manageparking;

import paking.car.IVehicle;


/**
 * Class for mapping concrete cell for parking(parking place) for different type Vehicle.
 */
abstract public class PlaceAbstract implements IPlaceParking {


    /**
     * field show us free parking place or not.
     */
    private boolean free = true;

    /**
     * field always array with one length for keeping parking vehicle
     */
    private final IVehicle[] vehicle = new IVehicle[1];

    public PlaceAbstract(byte size) {
        this.size = size;
    }

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

    public IVehicle[] getVehicle() {
        return vehicle;
    }

    public byte getSize() {
        return size;
    }

    /**
     * Procedure placing vehicle on parking place
     *
     * @param vehicle
     */
    public void occupyPlace(IVehicle vehicle) {
        this.vehicle[0] = vehicle;
        this.setFree(false);
    }

    public void setPlaceFree() {
        this.vehicle[0] = null;
        this.setFree(true);

    }

    /**
     * @return cell our array with vehicle if it has it.
     */
    public IVehicle getPlace() {
        return this.getVehicle()[0];
    }


    // abstract void CarOnPlace(Vehicle vehicle);


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
