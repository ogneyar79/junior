package ru.job4j.profession;


/**
 * Класс Profession общий для других профессий.
 *
 * @author Sirotkin.
 */
public class Profession {

    /**
     * name value of field for class Profession(The name that person has).
     */
    String name;

    /**
     * speciality value of field for class Profession.
     */
    String speciality;

    /**
     * salary value of field for class Profession.
     */
    int salary;

    /**
     * baseSal value of field for class Profession(minimum salary).
     */
    int baseSal;

    /**
     * hours value of field for class Profession ( quantity hours that persons work).
     */
    int hours = 100;

    /**
     * method for setting arguments.
     *
     * @param name       value for name
     * @param speciality value for speciality
     * @param baseSal    value for  baseSal
     */
    public Profession(String name, String speciality, int baseSal) {

        this.name = name;
        this.speciality = speciality;
        this.baseSal = baseSal;
    }

    /**
     * method for setting and getting salary.
     *
     * @return salary
     */
    public int paySal() {
        return salary;

    }

    /**
     * method for getting name.
     *
     * @return name
     */
    public String getName() {

        return this.name;
    }


}

