package ru.job4j.heroes;

public class Heroes implements IHeroes {


    private double life;

    private boolean privelege;

    private double demage;
    private double demageSecond;

    public Heroes() {
        this.life = 100;
    }

    public Heroes(double life, boolean privelege, double demage, double demageSecond) {
        this.life = life;
        this.privelege = privelege;
        this.demage = demage;
        this.demageSecond = demageSecond;
    }

    public Heroes(boolean privelege, double demage, double demageSecond) {
        this.life = 100;
        this.privelege = privelege;
        this.demage = demage;
        this.demageSecond = demageSecond;
    }


    public double getLife() {
        return life;
    }

    public boolean isPrivelege() {
        return privelege;
    }

    public double getDemage() {
        return demage;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public void setPrivelege(boolean privelege) {
        this.privelege = privelege;
    }

    public void setDemage(double demage) {
        this.demage = demage;
    }

    public double getDemageSecond() {
        return demageSecond;
    }

    public void setDemageSecond(double demageSecond) {
        this.demageSecond = demageSecond;
    }

    public void atack(Heroes hero) {
        if (!this.isPrivelege()) {
            hero.setLife(hero.getLife() - this.getDemage());
        } else {
            hero.setLife(hero.getLife() - this.getDemage() * 1.5);
            this.setPrivelege(false);
        }
    }

    public void secondAtack(Heroes hero) {
        if (!this.isPrivelege()) {
            hero.setLife(hero.getLife() - this.getDemageSecond());
        } else {
            hero.setLife(hero.getLife() - this.getDemageSecond() * 1.5);
            this.setPrivelege(false);
        }
    }


}
