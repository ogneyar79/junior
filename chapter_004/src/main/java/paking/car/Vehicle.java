package paking.car;

/**
 * Class  created for imitation different vehicle.
 */
abstract class Vehicle implements IVehicle {
    private final String tipe;
    private final byte size;
    private final int id;

    /**
     * Field object for transfer our car imitation different type of movement.
     */
  //  private IMovingVehicle movingCar;

    public Vehicle(String tipe, byte size, int id) {
        this.tipe = tipe;
        this.size = size;
        this.id = id;
    }

    public String getTipe() {
        return tipe;
    }

    public int getSize() {
        return size;
    }


}
