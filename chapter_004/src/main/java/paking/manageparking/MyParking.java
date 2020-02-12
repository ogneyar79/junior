package paking.manageparking;


import paking.car.IVehicle;

import java.util.List;

/**
 * Class our parking.
 */
public class MyParking implements IParking {

    /**
     * field list where keep cell for keeping car.
     */
    List<PlaceCar> carPPlist;
    /**
     * field list where keep cell for keeping track car.
     */

    List<PlaceTruck> trucksList;

    public MyParking(List<PlaceCar> carPPlist, List<PlaceTruck> trucksList) {
        this.carPPlist = carPPlist;
        this.trucksList = trucksList;
    }

    public List<PlaceCar> getCarPPlist() {
        return carPPlist;
    }

    public List<PlaceTruck> getTrucksList() {
        return trucksList;
    }


    @Override
    public void park(IVehicle car) {

    }

    @Override
    public PlaceAbstract parkWith(IVehicle car) {
        return null;
    }

    @Override
    public boolean returnFlag(IVehicle car) {
        return false;
    }
}
