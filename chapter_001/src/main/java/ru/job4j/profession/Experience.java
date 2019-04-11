package ru.job4j.profession;

/**
 * Created by maksi on 03.09.2017.
 */
public class Experience {

    private int number;
    private String nameEx;
    private int stage;
    private double levelExperience;


    public Experience(int number, String nameEx, int stage, int levelExperience) {
        this.number = number;
        this.nameEx = nameEx;
        this.stage = stage;
        this.levelExperience = levelExperience;
    }

    public int getNumber() {
        return number;
    }

    public String getNameEx() {
        return nameEx;
    }

    public int getStage() {
        return this.stage;
    }

    public double getLevelExperience() {
        return levelExperience;
    }

    private double changeLevelExperience() {
        levelExperience = this.stage * 0.5;
        return levelExperience;
    }
}