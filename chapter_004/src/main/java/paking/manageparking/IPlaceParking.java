package paking.manageparking;

import paking.car.IVehicle;


/**
 * Interface for creating and functioning parking place.
 */
public interface IPlaceParking {

    void occupyPlace(IVehicle car);

    void setPlaceFree();
}
