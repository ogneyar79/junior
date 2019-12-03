package ru.job4j.io.archive;

public class Args {

    /**
     * Constructor of  Args's class.
     *
     * @param directorySource
     * @param exceptionExpension
     * @param outDerictoryDestination
     */
    public Args(String directorySource, String exceptionExpension, String outDerictoryDestination) {
        this.directorySource = directorySource;
        this.exceptionExpension = exceptionExpension;
        this.outDerictoryDestination = outDerictoryDestination;
    }

    public Args() {

    }

    /**
     * Constructor of  Args's class.
     * <p>
     * Here We Set parametrs directorySource, exceptionExpension, outDerictoryDestination by use arguments
     *
     * @param arguments String that include keys at Cells and next Cell is field value.
     */
    public Args(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {

            if (arguments[i].intern() == ("-d").intern()) {
                this.setDirectorySource(arguments[i + 1]);
            }
            if (arguments[i].intern() == ("-e".intern())) {
                this.setExceptionExpension(arguments[i + 1]);

            }
            if (arguments[i].intern() == ("-o").intern()) {
                this.setOutDerictoryDestination(arguments[i + 1]);
            }
        }
    }

    /**
     * Field String, directory Where From we take file for oonverting.
     */
    private String directorySource;

    /**
     * Field String, Expension file Which we are not going to convert(kopy) from catalog.
     */
    private String exceptionExpension;

    /**
     * Field String, directory Where we going to oonverting.
     */
    private String outDerictoryDestination;

    private String name;
    private String mode;


    public String getDirectorySource() {
        return directorySource;
    }

    public String getExceptionExpension() {
        return exceptionExpension;
    }

    public String getOutDerictoryDestination() {
        return outDerictoryDestination;
    }

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public void setDirectorySource(String directorySource) {
        this.directorySource = directorySource;
    }

    public void setExceptionExpension(String exceptionExpension) {
        this.exceptionExpension = exceptionExpension;
    }

    public void setOutDerictoryDestination(String outDerictoryDestination) {
        this.outDerictoryDestination = outDerictoryDestination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
