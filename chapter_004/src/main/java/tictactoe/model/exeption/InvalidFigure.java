package tictactoe.model.exeption;

public class InvalidFigure extends XOException {
   String mesage;

    public InvalidFigure(String n) {
        super();
        mesage = n;
        System.out.println(n);
    }
}
