package paking;

import java.util.List;

/**
 * Class our parking.
 */
public class MyParking extends ParkingAb {

    /**
     * field list where keep cell for keeping car.
     */
    List<PlaceCar> carPPlist;
    /**
     * field list where keep cell for keeping track car.
     */

    List<PlaceTruck> trucksList;

    public MyParking(List<PlaceCar> carPPlist, List<PlaceTruck> trucksList, ILogicWork logicWork) {
        super(logicWork);


        this.carPPlist = carPPlist;
        this.trucksList = trucksList;
    }

    public List<PlaceCar> getCarPPlist() {
        return carPPlist;
    }

    public List<PlaceTruck> getTrucksList() {
        return trucksList;
    }

    /**
     * Procedure for work with our Parking and Car that we plan park.
     * inner our method we use Ilogic object.
     *
     * @param car
     */
    @Override
    void work(Car car) {
        super.getiLogicWork().workParking(car, this);
    }
}
