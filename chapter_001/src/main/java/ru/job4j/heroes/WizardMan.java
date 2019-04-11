package ru.job4j.heroes;

public class WizardMan extends People {
    public WizardMan() {
        super();
        setDemage(4);
    }

    void spell(Heroes hero) {

        hero.setPrivelege(true);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("Magic Atack - 4D");
    }
}
