package engine.render;

import engine.Configuration;
import game.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Render {

    private static BufferStrategy bufferStrategy;
    private static Graphics graphicsController;

    public static BufferStrategy getBufferStrategy() {
        return bufferStrategy;
    }

    public static void setBufferStrategy(BufferStrategy bufferStrategy) {
        Render.bufferStrategy = bufferStrategy;
    }

    public static Graphics getGraphicsController() {
        return graphicsController;
    }

    public static void setGraphicsController(Graphics graphicsController) {
        Render.graphicsController = graphicsController;
    }

    public static void renderGame(){
        //Handle and init buffer amount of buffers
        Render.setBufferStrategy(Game.display.getCanvas().getBufferStrategy());
        if(Render.getBufferStrategy() == null){ Game.display.getCanvas().createBufferStrategy(3); return; }

        //Basic graphics startup
        Render.setGraphicsController(Render.getBufferStrategy().getDrawGraphics());
        Render.getGraphicsController().clearRect(0,0, Game.width, Game.height); //Clear Screen

        //Begin drawing
        int x = 0, y = 0;

        for (BufferedImage b : Game.sheet.imageSprites) {
            graphicsController.drawImage(b,  (int)(x*Configuration.tileWidth), (int)(y*Configuration.tileWidth),null);
            if (y == 14) {y = 0; x++;} else { y++; }
        }


        //End drawing
        Render.getBufferStrategy().show();
        Render.getGraphicsController().dispose();
    }
}
