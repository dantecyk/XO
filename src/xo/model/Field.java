package xo.model;

import xo.model.exceptions.AlreadyOccupaitedException;
import xo.model.exceptions.InvalidePointException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;
    private static final int MAX_COORDINAT = FIELD_SIZE;
    private static final int MIN_COORDINAT = 0;

    private final Figure [][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidePointException{
        if (!checkPoint(point)) {
            throw new InvalidePointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidePointException,
                                                                            AlreadyOccupaitedException {
        if (!checkPoint(point)) {
            throw new InvalidePointException();
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