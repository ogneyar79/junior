package ru.job4j.heroes;

public class HunterUndead extends Undead {
    public HunterUndead() {
        super();
        setDemage(4);
        setDemageSecond(2);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("BowAtack");
    }

    @Override
    public void secondAtack(Heroes hero) {
        super.secondAtack(hero);
        System.out.println("StepAtack");
    }
}
