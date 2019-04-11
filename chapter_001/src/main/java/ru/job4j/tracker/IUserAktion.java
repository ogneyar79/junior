package ru.job4j.tracker;

public interface IUserAktion {

    int key();

    void execute(IInput input, Tracker tracker);

    String info();

}
