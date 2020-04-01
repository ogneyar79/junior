package tictactoe.common;

import tictactoe.model.exeption.XOCriticalException;

import java.io.IOException;

public interface IXOProperty {

    public Character getSeparatorCharacter();

    static IXOProperty getDefaultProperties() {

        try {
            return XOPropertyBase.generateInstance();
        } catch (final IOException e) {
            e.printStackTrace();
            throw new XOCriticalException(e);
        }
    }

}
