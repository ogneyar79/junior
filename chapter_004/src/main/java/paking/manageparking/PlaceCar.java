package paking.manageparking;

public class PlaceCar extends PlaceAbstract {
    final int number;
    final String typeName = "LightCar";

    public PlaceCar(int number) {
        super((byte) 4);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getTypeName() {
        return typeName;
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
