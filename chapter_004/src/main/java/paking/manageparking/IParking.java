package paking.manageparking;

import paking.car.IVehicle;
import paking.car.Vehicle;

interface IParking {

    void park(Vehicle car);

PlaceAbstract getFreePlace();

boolean returnFlag(Vehicle car);

}
