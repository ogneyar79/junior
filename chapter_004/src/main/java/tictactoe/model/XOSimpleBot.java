package tictactoe.model;

public class XOSimpleBot {

  private final   String botName;

  private final Figure figure;

  private final LogicalBiohaver logic;

    public XOSimpleBot(String botName, Figure figure, LogicalBiohaver logic) {
        this.botName = botName;
        this.figure = figure;
        this.logic = logic;
    }
}
