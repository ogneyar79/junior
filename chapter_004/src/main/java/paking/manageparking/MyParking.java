package paking.manageparking;


import paking.car.ParkingMove;
import paking.car.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Class our parking.
 */
public class MyParking implements IParking {

    /**
     * field is object with list of Places Car , keep cell for keeping car.
     */
    private final GroupPlaceCar placesCar;

    /**
     * field is object with list of Places Car , keep cell for keeping track car.
     */

    private final GroupPlaceTrack placesTrack;

    /**
     * Quantity of parking Place for parking Car.
     */
    private final int numberPlaceCar;

    /**
     * Quantity of parking Place for parking Track car.
     */
    private final int numberPlaceTrack;

    /**
     * field for message To CAR , Which place It can park To.
     */
    private final ArrayList<PlaceAbstract> freePlaceList = new ArrayList<>(2);

    /**
     * Procedure set frePlaceList.
     *
     * @param placeFree
     */
    public void setPlaceFree(PlaceAbstract placeFree) {
        freePlaceList.add(placeFree);
    }

    /**
     * Constructor our Class.
     *
     * @param placesCar
     * @param placesTrack
     */
    public MyParking(GroupPlaceCar placesCar, GroupPlaceTrack placesTrack) {
        this.placesCar = placesCar;
        this.placesTrack = placesTrack;
        numberPlaceCar = this.placesCar.getNumberPlace();
        numberPlaceTrack = this.placesTrack.getNumberPlace();
    }

    /**
     * Function for geting free place from our parking (from one of our fields where vehicle stay).
     *
     * @param vehicleArray
     * @return
     */
    public PlaceAbstract findFreePlace(IPlaceParking[] vehicleArray) {
        return (PlaceAbstract) Arrays.stream(vehicleArray).filter(s -> s.isFree()).limit(1);
    }

    /**
     * Method process parking Vehicles.
     *
     * @param car
     */
    @Override
    public void park(Vehicle car) {
        if (this.returnFlag(car)) {
            car.move(new ParkingMove(this.getFreePlace()));
        }

        if ((car.getType().equalsIgnoreCase(this.placesTrack.getType())) && !(this.returnFlag(car)) & (this.placesCar.isTwoPlaceIs())) {
            ArrayList<PlaceCar> localPpace = new ArrayList(2);
            localPpace = this.placesCar.findNearFreePlace();
            this.setPlaceFree(localPpace.get(0));
            this.setPlaceFree(localPpace.get(1));
            car.move(new ParkingMove(this.getFreePlace()));
            car.move(new ParkingMove(this.getFreePlace()));
        }
        System.out.println("NO PARKING");
    }


    /**
     * Function getting Place Where vehicle can park from our freePlaceList
     * after get it this place deleted from list.
     *
     * @return
     */
    @Override
    public PlaceAbstract getFreePlace() {
        PlaceAbstract placeAbstract = this.freePlaceList.get(0);
        freePlaceList.remove(0);
        return placeAbstract;

    }

    /**
     * Function that return Boolean that place for parking or not for Type Vehicle.
     *
     * @param car
     * @return
     */
    @Override
    public boolean returnFlag(Vehicle car) {
        boolean result = false;
        if (car.getType().equalsIgnoreCase(this.placesTrack.getType()) & (this.placesTrack.getSumFreePlace() > 0)) {
            PlaceAbstract placeAbstract = this.findFreePlace(placesTrack.getPlaceParcingsArray());
            this.setPlaceFree(placeAbstract);
            result = true;
        }
        if (car.getType().equalsIgnoreCase(this.placesCar.getType()) & (this.placesCar.getSumFreePlace() > 0)) {
            PlaceAbstract placeAbstract = this.findFreePlace(placesCar.getPlaceParcingsArray());
            this.setPlaceFree(placeAbstract);
            result = true;
        }
        return result;
    }

    public int getNumberPlaceCar() {
        return numberPlaceCar;
    }

    public int getNumberPlaceTrack() {
        return numberPlaceTrack;
    }

    public ArrayList<PlaceAbstract> getFreePlaceList() {
        return freePlaceList;
    }
}






