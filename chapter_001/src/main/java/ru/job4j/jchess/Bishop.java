
package ru.job4j.jchess;

/**
 * Created by maksi on 03.11.2017.
 */
/*public class Bishop extends Figure {

    /**
     * method for creaction Item object.
     *
     * @param name            String
     * @param currentPosition Cell
     * @param firstPosition   Cell
     */
  /*  public Bishop(final String name, Cell currentPosition, final Cell firstPosition) {
        super(name, currentPosition, firstPosition);
    }

    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] cel1s = new Cell[63];
        if (((dist.getCell_oneCoordinate() - currentPosition.getCell_oneCoordinate()) % 7 == 0 || (dist.getCell_oneCoordinate() - currentPosition.getCell_oneCoordinate()) % 9 == 0) && (dist.getCell_oneCoordinate() - currentPosition.getCell_oneCoordinate() > 0 || dist.getCell_oneCoordinate() - currentPosition.getCell_oneCoordinate() < 64) && (dist.getColor() == currentPosition.getColor())) {

            if (dist.getCell_oneCoordinate() > currentPosition.getCell_oneCoordinate()) {
                cel1s = new Cell[dist.getCell_oneCoordinate() - currentPosition.getCell_oneCoordinate()];
                for (int i = dist.cell_oneCoordinate; i >= currentPosition.getCell_oneCoordinate(); i--) {

                }
            } else {
                cel1s = new Cell[currentPosition.getCell_oneCoordinate() - dist.getCell_oneCoordinate()];
                for (int i = currentPosition.getCell_oneCoordinate(); i >= dist.getCell_oneCoordinate(); i--) {

                }
            }
        } else {

            throw new ImposibleMoveException();
        }

        return cel1s;
    }

    @Override
    public Cell clone(Cell dist) {
        this.currentPosition = dist;
        return currentPosition;
    }

    public void makeWay() {
        final Cell dist = null;
        try {
            way(dist);
        } catch (final ImposibleMoveException e) {
            e.printStackTrace();
        }
    }


}*/