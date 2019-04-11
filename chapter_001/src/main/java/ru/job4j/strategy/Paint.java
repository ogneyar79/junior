package ru.job4j.strategy;

/**
 * класс Paint for realisation pattern Strategy(kontext).
 *
 * @author Sirotkin.
 *
 */
public class Paint {


    /**
     *@ param field shape IShape.
     *
     */
    private IShape shape;

     String result = new Triangle().getResult();


    /**
     *for setting field IShape shape.
     *
     */
    public void setShape(IShape shape) {
        this.shape = shape;
    }

    /**
     *method for realisation methods interface IShape for outputting for console.
     *
     */
        public void draw() {
        this.shape.pic();
    }

    /**
     *for getting shape.
     * @return shape
     */
        public IShape getShape() {
        return shape;
    }
}