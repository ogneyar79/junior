package ru.job4j.heroes;

public class GoblinOrk extends Orks {
    public GoblinOrk() {
        super();
        setDemage(20);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("ClubAtack - 20D");
    }
}
