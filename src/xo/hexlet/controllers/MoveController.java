package xo.hexlet.controllers;


import xo.hexlet.model.Field;
import xo.hexlet.model.Figure;
import xo.hexlet.model.exceptions.AlreadyOccupitedException;
import xo.hexlet.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException, AlreadyOccupitedException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupitedException();
        }
        field.setFigure(point, figure);
    }

}
