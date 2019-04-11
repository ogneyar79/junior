package ru.job4j.strategy;

public class Triangle implements IShape {


    public String getResult() {
        return result;
    }

    private String result;

    /**
     * method that is realisation interface, outputting triangle at console.
     *
     * @ return result
     */
    @Override
    public String pic() {

        StringBuilder triangleBuilder = new StringBuilder();

        triangleBuilder.append("+" + "    ");
        triangleBuilder.append(System.lineSeparator());
        triangleBuilder.append("++" + "   ");
        triangleBuilder.append(System.lineSeparator());
        triangleBuilder.append("+" + " " + "+" + "  ");
        triangleBuilder.append(System.lineSeparator());
        triangleBuilder.append("+" + "  " + "+" + " ");
        triangleBuilder.append(System.lineSeparator());
        triangleBuilder.append("+++++");
        triangleBuilder.append(System.lineSeparator());
        result = triangleBuilder.toString();
        System.out.println(result);
        return result;
    }


}