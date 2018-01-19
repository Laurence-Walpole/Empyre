package game;

import engine.Configuration;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game(Configuration.gameName, Configuration.windowWidth, Configuration.windowHeight);
        game.start();
    }

}
