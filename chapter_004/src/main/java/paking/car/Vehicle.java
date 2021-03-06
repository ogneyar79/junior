package paking.car;

/**
 * Class  created for imitation different vehicle.
 */
abstract public class Vehicle implements IVehicle {
    private final String type;
    private final byte size;
    private final int id;

    /**
     * Field object for transfer our car imitation different type of movement.
     */
    //  private IMovingVehicle movingCar;
    public Vehicle(final String type, byte size, int id) {
        this.type = type;
        this.size = size;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }


}
