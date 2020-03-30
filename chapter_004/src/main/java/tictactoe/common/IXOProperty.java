package tictactoe.common;

import java.io.IOException;

public interface IXOProperty {

    public Character getSeparatorCharacter();

    static IXOProperty getDefaultProperties() throws IOException {

        return XOPropertyBase.generateInstance();

    }

}
