package paking;

/**
 * Class car this created for imitation different vehicle.
 */
abstract class Car {
    private final String tipe;
    private final byte size;
    private final int id;

    /**
     * Field object for transfer our car imitation different type of movement.
     */
    private IMovingCar movingCar;

    public Car(String tipe, byte size, int id) {
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

    public void setIMovingCar(IMovingCar movingCar) {
        this.movingCar = movingCar;
    }

    /**
     * procedure that use for imitation different movement of car.
     * @param movingCar
     */
    public void move(IMovingCar movingCar){
        movingCar.move();
    }
}
