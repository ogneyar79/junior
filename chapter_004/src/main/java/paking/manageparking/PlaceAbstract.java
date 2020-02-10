package paking.manageparking;

import paking.car.IVehicle;


/**
 * Class for mapping concrete cell for parking(parking place) for different type Vehicle.
 */
abstract class PlaceAbstract implements IPlaceParking{

    /**
     * field show us free parking place or not.
     */
    private boolean freeOrNo = false;

    /**
     * field always array with one length for keeping parking vehicle
     */
    private final IVehicle[] vehicle = new IVehicle[1];

    /**
     * field show size of our parking cell
     */
    private byte size;

    public void setSize(byte size) {
        this.size = size;
    }

    public void setFreeOrNo(boolean freeOrNo) {
        this.freeOrNo = freeOrNo;
    }

    public boolean isFreeOrNo() {
        return freeOrNo;
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
    }

    /**
     * @return cell our array with vehicle if it has it.
     */
    public IVehicle getPlace() {
        return this.getVehicle()[0];
    }
    // abstract void CarOnPlace(Vehicle vehicle);

}
