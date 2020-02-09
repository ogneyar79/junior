package paking;

public class PlaceTruck extends Place {
    final String tipe;

    public PlaceTruck(String tipe) {
        this.setSize((byte) 6);
        this.tipe = tipe;
    }
}
