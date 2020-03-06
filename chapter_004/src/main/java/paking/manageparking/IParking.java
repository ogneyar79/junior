package paking.manageparking;

import paking.car.IVehicle;
import paking.car.Vehicle;

interface IParking {

    void park(Vehicle car) throws MyParking.MyException;

PlaceAbstract getFreePlace() throws MyParking.MyException;

boolean returnFlag(Vehicle car);

}
