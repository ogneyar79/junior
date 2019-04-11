package ru.job4j.heroes;

public class ShamanOrk extends Orks {

    public ShamanOrk() {
        super();

    }

    void spell(Heroes hero) {
        hero.setPrivelege(true);
    }

    void curse(Heroes hero) {
        hero.setPrivelege(false);
    }
}
