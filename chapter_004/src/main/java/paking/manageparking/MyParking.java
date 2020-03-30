package paking.manageparking;


import paking.car.ParkingMove;
import paking.car.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


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
    public Optional<PlaceAbstract> findFreePlace(PlaceAbstract[] vehicleArray) {
        return Arrays.stream(vehicleArray).filter(s -> s.isFree()).limit(1).findAny();
    }

    /**
     * Method process parking Vehicles.
     *
     * @param car
     */
    @Override
    public void park(Vehicle car) throws MyException {
        if (this.returnFlag(car)) {
            car.move(new ParkingMove(this.getFreePlace()));
        } else if ((car.getType().equalsIgnoreCase(this.placesTrack.getType())) && !(this.returnFlag(car)) & (this.placesCar.isTwoPlaceIs())) {
            ArrayList<PlaceCar> localPlace;
            localPlace = this.placesCar.findNearFreePlace();
            this.setPlaceFree(localPlace.get(0));
            this.setPlaceFree(localPlace.get(1));
            car.move(new ParkingMove(this.getFreePlace()));
            car.move(new ParkingMove(this.getFreePlace()));
        } else {
            System.out.println("NO PARKING");
        }

    }

    /**
     * Function getting Place Where vehicle can park from our freePlaceList
     * after get it this place deleted from list. Think make this method private.
     *
     * @return
     */
    @Override
    public PlaceAbstract getFreePlace() throws MyException {
        if (freePlaceList.isEmpty()) {
            throw new MyException("this Object was created Before use method park()!");
        }
        PlaceAbstract placeAbstract = this.freePlaceList.get(0);
        freePlaceList.remove(0);
        return placeAbstract;

    }

    /**
     * Function that return Boolean that place for parking or not for Type Vehicle.
     * And if have free place for parking we set our freePlaceList
     * and copy there address Place Where then we transfer our parked Car.
     *
     * @param car
     * @return
     */
    @Override
    public boolean returnFlag(Vehicle car) {
        boolean result = false;
        if (car.getType().equalsIgnoreCase(this.placesTrack.getType()) & (this.placesTrack.getSumFreePlace() > 0)) {
            PlaceAbstract placeAbstract = this.findFreePlace(placesTrack.getPlaceParcingsArray()).get();
            this.setPlaceFree(placeAbstract);
            result = true;
        }
        if (car.getType().equalsIgnoreCase(this.placesCar.getType()) & (this.placesCar.getSumFreePlace() > 0)) {
            PlaceAbstract placeAbstract = this.findFreePlace(placesCar.getPlaceParcingsArray()).get();
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

    class MyException extends Throwable {

        public MyException(String s) {
        }
    }

    public GroupPlaceCar getPlacesCar() {
        return placesCar;
    }

    public GroupPlaceTrack getPlacesTrack() {
        return placesTrack;
    }
}






