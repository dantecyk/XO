package xo.hexlet;


import xo.hexlet.model.Field;
import xo.hexlet.model.Figure;
import xo.hexlet.model.Game;
import xo.hexlet.model.Player;
import xo.hexlet.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Dima";
        final String name2 = "Nastya";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);

        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

}
