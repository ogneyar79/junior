package ru.job4j.heroes;

public class ZombyUndead extends Undead {
    public ZombyUndead() {
        super();
        setDemage(18);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("ZombyAtack By Lance");
    }
}
