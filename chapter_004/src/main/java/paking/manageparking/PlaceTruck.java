package paking.manageparking;

/**
 * Class, place for placing Track.
 */
public class PlaceTruck extends PlaceAbstract {

    final int number;
    final String typeName = "Track";

    public PlaceTruck(int number) {
        super((byte) 6);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public void setPlaceFree() {

    }
}
