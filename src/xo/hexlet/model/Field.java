package xo.hexlet.model;

import xo.hexlet.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINAT = 0;

    private final Figure[][] field;

    private final int filedSize;

    public Field(int fieldSize) {
        this.filedSize = fieldSize;
        field = new Figure[filedSize][filedSize];
    }

    public int getSize() {
        return filedSize;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINAT && coordinate < maxCoordinate;
    }

}
