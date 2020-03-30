package paking.manageparking;

import paking.car.IVehicle;
import paking.car.Vehicle;

import java.util.Arrays;

abstract public class AGroupPlaceVehicle {


    // public final List<IPlaceParking<IVehicle>> vehiclePlace;

    private final PlaceAbstract[] placeParcingsArray;
    private int sumFreePlace;

    private String type;

    private final int numberPlace;


    AGroupPlaceVehicle(int numberPlace, PlaceAbstract placeAbstract) {
        this.numberPlace = numberPlace;
        this.placeParcingsArray = new PlaceAbstract[numberPlace];
        this.placeAbstract = placeAbstract;
        this.sumFreePlace = numberPlace;
        this.type = placeAbstract.getTypeName();
        this.createGroupPlace(numberPlace);
    }


    final private PlaceAbstract<Vehicle> placeAbstract;

    /**
     * Procedure for fill  in field of object(IPlaceParking[] placeParcingsArray).
     *
     * @param numberPlace
     */
    protected void createGroupPlace(int numberPlace) {
        for (int i = 0; i < numberPlace; i++) {
            this.setAtPlaceGroup(i, this.placeAbstract.createNewInstance(i + 1));
        }

    }

    public void setAtPlaceGroup(int index, PlaceAbstract object) {
        this.placeParcingsArray[index] = object;
    }

    public PlaceAbstract[] getPlaceParcingsArray() {
        return placeParcingsArray;
    }

    int countFreePlace() {

        return (int) Arrays.stream(this.placeParcingsArray).filter(s -> s.isFree()).count();
    }


    public String getType() {
        return type;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public IPlaceParking getPlace(int index) {
        return this.getPlaceParcingsArray()[index];
    }

    public IVehicle getCarWithIndex(int index) {
        return this.getPlaceParcingsArray()[index].makePlaceFree();
    }

    public int getSumFreePlace() {
        return (int) Arrays.stream(this.placeParcingsArray).filter(s -> s.isFree()).count();
    }
}
