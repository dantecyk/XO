package xo.model;

import xo.model.exceptions.AlreadyOccupaitedException;
import xo.model.exceptions.InvalidPointException;
import xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;
    private static final int MAX_COORDINAT = FIELD_SIZE;
    private static final int MIN_COORDINAT = 0;

    private final Figure [][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidPointException{
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException,
                                                                            AlreadyOccupaitedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (field[point.x][point.y] != null) {
            throw new AlreadyOccupaitedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINAT && coordinate < MAX_COORDINAT;
    }

}
