package ru.job4j.heroes;

public class ArbalesterMan extends People {

    public ArbalesterMan() {
        super();
        setDemage(5);
        setDemageSecond(3);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("Arbalet Atack - 5D");
    }

    @Override
    public void secondAtack(Heroes hero) {
        super.secondAtack(hero);
        System.out.println("StepAtack - 3D");
    }
}
