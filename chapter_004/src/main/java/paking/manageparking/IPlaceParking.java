package paking.manageparking;

import paking.car.IVehicle;


/**
 * Interface for creating and functioning parking place.
 */
public interface IPlaceParking<T extends IVehicle> {

    void occupyPlace(T car);

    T makePlaceFree();

    String getTypeName();

    boolean isFree();


}
