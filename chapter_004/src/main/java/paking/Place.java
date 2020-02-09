package paking;

/**
 * Class for mapping concrete cell for parking(parking place).
 */
abstract class Place {

    /**
     * field show us free parking place or not.
     */
    private boolean freeOrNo = false;

    /**
     * field always array with one length for keeping parking car
     */
    private final Car[] car = new Car[1];

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

    public Car[] getCar() {
        return car;
    }

    public byte getSize() {
        return size;
    }

    /**
     * Procedure placing car on parking place
     * @param car
     */
    public void beingPlaceOcupaded(Car car) {
        this.car[0] = car;
    }

    /**
     *
     * @return cell our array with car if it has it.
     */
    public Car getPlace() {
        return this.getCar()[0];
    }
    // abstract void CarOnPlace(Car car);

}
