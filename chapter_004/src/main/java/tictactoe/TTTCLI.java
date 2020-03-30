package tictactoe;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.view.ConsoleView;

public class TTTCLI {

    public static void main(final String... args) {
        final String nameOne = "Ivan";
        final String nameTwo = "Robert";
        final Player[] players = new Player[2];
        players[0] = new Player(nameOne, Figure.X);
        players[1] = new Player(nameTwo, Figure.O);
        final Game game = new Game(players, new Field(3), "GameOne");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
    }

}
