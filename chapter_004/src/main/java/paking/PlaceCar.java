package paking;

import net.bytebuddy.implementation.bytecode.StackManipulation;

public class PlaceCar extends Place {

final String tipe;

    public PlaceCar(String tipe) {
        this.setSize((byte) 4);
        this.tipe = tipe;
    }




}
