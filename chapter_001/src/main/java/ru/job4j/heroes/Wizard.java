package ru.job4j.heroes;

public class Wizard extends Elfs {
    public Wizard() {
        super();
        setDemage(10);
    }

    public Wizard(double life, boolean privelege, double demage, double demageSecond) {
        super(life, privelege, demage, demageSecond);
    }

    public Wizard(boolean privelege, double demage, double demageSecond) {
        super(privelege, demage, demageSecond);
    }

    void spell(Heroes hero) {

        hero.setPrivelege(true);

    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("Magic Atack - 10D");
    }
}
