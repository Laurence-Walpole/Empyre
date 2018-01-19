package engine.render;

import engine.Configuration;
import net.coobird.thumbnailator.Thumbnails;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class SpriteSheet {

    private static BufferedImage sheet;
    private static int imageSize = Configuration.imageWidth, sheetWidth = 7, sheetHeight = 14;
    public static LinkedList<BufferedImage> imageSprites = new LinkedList<>();

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
        loadSprites();
    }

    private static void loadSprites(){
        int var = 4;
        int xPos = 0, yPos = 0;
        for (int y = 0; y < sheetHeight; y++){
            for (int x = 0; x < sheetWidth; x++){
                imageSprites.add(crop(xPos, yPos, imageSize, imageSize + var));
                xPos = imageSize * x;
            }
            if (y % 2 == 0 || y == 0){
                var = 4;
            }
            else{
                var = 5;
            }

            yPos = (imageSize + var) * y;
        }
    }

    private static BufferedImage crop(int x, int y, int width, int height) {
        BufferedImage _img = null;
        try {
            _img = Thumbnails.of(sheet.getSubimage(x, y, width, height)).scale(Configuration.imageScale).asBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return _img;
    }
}
