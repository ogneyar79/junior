package paking.manageparking;

/**
 * Class, place for placing Track.
 */
public class PlaceTruck extends PlaceAbstract {

    final String number;
    final String typeName = "Track";

    public PlaceTruck(String number) {
        this.setSize((byte) 6);
        this.number = number;
    }

    @Override
    public void setFrePlace() {

    }
}
