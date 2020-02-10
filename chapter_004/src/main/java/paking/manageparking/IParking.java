package paking.manageparking;

import paking.car.IVehicle;

interface IParking {

    void park(IVehicle car);

PlaceAbstract parkWith(IVehicle car);

boolean returnFlag(IVehicle car);

}
