package ru.job4j.strategy;

public class Square implements IShape {


    /**
     * method that is realisation interface, outputting square at console.
     *
     * @return squareBuilder
     */
    @Override
    public String pic() {
        StringBuilder squareBuilder = new StringBuilder();

        squareBuilder.append("+++++");
        squareBuilder.append(System.lineSeparator());
        squareBuilder.append("+" + "   " + "+");
        squareBuilder.append(System.lineSeparator());
        squareBuilder.append("+++++");
        squareBuilder.append(System.lineSeparator());
        squareBuilder.append("+" + "   " + "+");
        squareBuilder.append(System.lineSeparator());
        squareBuilder.append("+++++");
        System.out.println(squareBuilder.toString());
        return squareBuilder.toString();

    }
}