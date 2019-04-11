package ru.job4j.bank;

public class Pasport {

    private int number;
    private String firstName;
    private String cecondName;


    public Pasport(int number, String firstName, String cecondName) {
        this.number = number;
        this.firstName = firstName;
        this.cecondName = cecondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pasport)) {
            return false;
        }

        Pasport pasport = (Pasport) o;

        if (number != pasport.number) {
            return false;
        }
        if (!firstName.equals(pasport.firstName)) {
            return false;
        }
        return cecondName.equals(pasport.cecondName);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + cecondName.hashCode();
        return result;
    }
}
