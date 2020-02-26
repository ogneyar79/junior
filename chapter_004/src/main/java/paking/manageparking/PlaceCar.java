package paking.manageparking;

public class PlaceCar extends PlaceAbstract {

    final String typeName = "LightCar";

    public PlaceCar(int number) {
        super(number, (byte) 4);

    }

    public int getNumber() {
        return number;
    }

    public String getTypeName() {
        return typeName;
    }


    @Override
    public PlaceAbstract createNewInstance(int number) {
        return new PlaceCar(number);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
