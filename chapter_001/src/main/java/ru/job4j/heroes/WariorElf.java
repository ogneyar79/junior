package ru.job4j.heroes;

public class WariorElf extends Elfs {
    public WariorElf() {
        super();
        setDemage(15);
    }

    public void atack(Heroes hero) {

        hero.setLife(hero.getLife() - this.getDemage());
        System.out.println("WariorAtack - 15D");
    }

    }
