package engine;

import engine.world.Tile;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Configuration {
    public static String gameName = "Empyre";
    public static int windowWidth = 600, windowHeight = 900;
    public static double imageScale = 0.5;
    public static int imageWidth = 128;
    public static double tileWidth = imageWidth * imageScale;
    public static String basicTiles = "/textures/basicTiles.png";

    private static LinkedList<Tile> tileList = new LinkedList<>();

    public static void addTile(String tileName, BufferedImage tileImage, int x, int y){
        Tile _tile = new Tile(tileName, tileImage, x, y);
        tileList.add(_tile);
    }

    public static void updateTile(String uid, BufferedImage tileImage){
        for (Tile t : tileList) {
            if(t.getUid() == uid){
                t.setImage(tileImage);
            }
        }
    }

    public static void removeTile(String uid){
        for (Tile t : tileList){
            if(t.getUid() == uid){
                tileList.remove(t);
            }
        }
    }
}
