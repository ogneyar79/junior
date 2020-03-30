package tictactoe.model;

/**
 * Class that has information about players, current name of game.
 * and field Field where game is.
 */
public class Game {

    private final Player[] players;

    private final Field field;

    private final String name;

    private final Figure firstFigure;

    public Game(final Player[] players, final Field field, final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
        firstFigure = this.players[0].getFigure();  /// make at game
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public Figure getFirstFigure() {
        return firstFigure;
    }
}
