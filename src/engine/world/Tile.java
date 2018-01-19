package engine.world;

import java.awt.image.BufferedImage;

public class Tile {

    private static String name;
    private static BufferedImage image;
    private static int x, y;
    private static String uid;

    public Tile(String tileName, BufferedImage tileImage, int tileX, int tileY){
        this.name = tileName;
        this.image = tileImage;
        this.x = tileX;
        this.y = tileY;
        this.uid = generateUid();
    }

    public static String getName() {
        return name;
    }

    public static BufferedImage getImage() {
        return image;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static void setImage(BufferedImage image) {
        Tile.image = image;
    }

    public static String getUid() {
        return uid;
    }

    public static String generateUid(){
        String uid = "X" + getX() + "Y" + getY();
        return uid;
    }
}
