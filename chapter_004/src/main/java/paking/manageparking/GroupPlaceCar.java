package paking.manageparking;

import java.util.ArrayList;

public class GroupPlaceCar extends AGroupPlaceVehicle {

    protected GroupPlaceCar(int numberPlace, PlaceAbstract placeAbstract) {
        super(numberPlace, placeAbstract);
    }

    private boolean twoPlaceIs;

    public ArrayList<PlaceCar> findNearFreePlace() {

        ArrayList<PlaceCar> placeCarList = new ArrayList<>(2);
        for (int i = 0; i < super.getPlaceParcingsArray().length; i++) {
            PlaceCar placeCar = (PlaceCar) this.getPlace(i);
            if (placeCar.isFree()) {
                PlaceCar placeCarNext = (PlaceCar) this.getPlace(i + 1);
                if (placeCarNext.isFree()) {
                    placeCarList.add(placeCar);
                    placeCarList.add(placeCarNext);
                    this.twoPlaceIs = true;
                    return placeCarList;
                }
            }
        }
        this.twoPlaceIs = false;
        return placeCarList;
    }

    public boolean isTwoPlaceIs() {
        this.findNearFreePlace();
        return twoPlaceIs;
    }
}
