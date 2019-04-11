package ru.job4j.heroes;

public class ArcherElf extends Elfs {
    public ArcherElf() {
        super();
        setDemage(7);
        setDemageSecond(3);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("BowAtack - 7D");
    }

    @Override
    public void secondAtack(Heroes hero) {
        super.secondAtack(hero);
        System.out.println("StepAtack - 3D");
    }
}
