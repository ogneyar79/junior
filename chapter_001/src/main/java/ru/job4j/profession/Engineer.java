package ru.job4j.profession;

/**
 * Created by maksi on 27.08.2017.
 */
public class Engineer extends Profession {


    /**
     * expireence value of field for class Engineer.
     */
    private int experience;


    public int getExperience() {
        return experience;
    }

    /**
     * method for setting arguments.
     *
     * @param name       value for name
     * @param speciality value for speciality
     * @param baseSal    value for  baseSal
     */
    public Engineer(String name, String speciality, int baseSal, int experience) {

        super(name, speciality, baseSal);
        this.experience = experience;
    }

    Engineer pbPetrov = new Engineer("Пeтров Иван", "Инжинер по коммуникациям", 40000, 1);


    @Override
    /**
     * method for setting and getting salary.
     * @return salary
     */
    public int paySal() {
        this.salary = this.baseSal * experience;
        return salary;

    }

    /**
     * method that show what engineer to do now.
     */
    public void engeenerWork(Engineer pbPetrov, Project bridge) {

        System.out.println("Engineer" + " " + this.getName() + " " + "are making" + bridge.getProjectName());

    }
}
