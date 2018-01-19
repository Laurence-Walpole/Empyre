package game;

import engine.Configuration;
import engine.render.Display;
import engine.render.ImageLoader;
import engine.render.Render;
import engine.render.SpriteSheet;

public class Game implements Runnable{

    public static Display display;
    public static int width, height;
    public String title;
    public static SpriteSheet sheet;

    private Thread thread;
    private boolean running = false;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
        sheet = new SpriteSheet(ImageLoader.loadImage(Configuration.basicTiles));

    }

    private void tick(){

    }

    public void run(){
        init();
        while(running){
            tick();
            Render.renderGame();
        }
        stop();
    }

    public synchronized void start(){
        if(running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running) return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
