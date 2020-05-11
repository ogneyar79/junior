package tictactoe.common;

import java.io.*;

import java.util.Properties;

/**
 *
 */
class XOPropertyBase implements IXOProperty {

    private static final String PROPERTY_FILE = "xo.property";

    private static final String SEPARATOR_KEY = "separator";
    private final Properties properties;


    public static IXOProperty generateInstance() throws IOException {
        final Properties properties = new Properties();
        final InputStream in = XOPropertyBase.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);
        properties.load(in);
        return new XOPropertyBase(properties);
    }

    private XOPropertyBase(final Properties properties) {
        this.properties = properties;
    }

    @Override
    public Character getSeparatorCharacter() {
        return this.properties.getProperty(SEPARATOR_KEY).charAt(0);
    }

    public static void main(String... args) throws IOException {
        XOPropertyBase.generateInstance().getSeparatorCharacter();
        System.out.println(XOPropertyBase.generateInstance());


        if (true) {
            System.err.print("Fuck");
        }
        System.err.print(" NoFuck");

    }


}


