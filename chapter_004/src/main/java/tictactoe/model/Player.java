package tictactoe.model;

/**
 * class for Player.
 */
public class Player {

    /**
     * name String.
     */
    private final String name;

    /**
     * Figure which player make steps usually or Cross or Toe.
     */
    private final Figure figure;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }
}
