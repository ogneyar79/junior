package ru.job4j.heroes;

public class NecromancerUndead extends Undead {

    public NecromancerUndead() {
        super();
        setDemage(5);
    }

    public void spellWeak(Heroes hero) {
        hero.setDemage(hero.getDemage() / 2);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("NecromancerAtack");
    }
}
