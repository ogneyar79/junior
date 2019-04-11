package ru.job4j.heroes;

public class BowOrks extends Orks {

    public BowOrks() {
        super();
        setDemage(3);
        setDemageSecond(2);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("Bow Atack - 3D");
    }

    @Override
    public void secondAtack(Heroes hero) {
        super.secondAtack(hero);
        System.out.println("Step Atack - 2D");
    }
}
