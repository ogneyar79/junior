package ru.job4j.heroes;

public class WariorMan extends People {

    public WariorMan() {
        super();
        setDemage(18);
    }

    @Override
    public void atack(Heroes hero) {
        super.atack(hero);
        System.out.println("WariorAtak - 18");
    }
}
