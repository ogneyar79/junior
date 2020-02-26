package paking.manageparking;

/**
 * Class, place for placing Track.
 */
public class PlaceTruck extends PlaceAbstract {


    final String typeName = "Track";

    public PlaceTruck(int number) {
        super(number, (byte) 6);

    }

    public int getNumber() {
        return number;
    }

    public String getTypeName() {
        return typeName;
    }


    @Override
    public  PlaceAbstract createNewInstance(int number) {
        return new PlaceTruck(number);
    }
}
