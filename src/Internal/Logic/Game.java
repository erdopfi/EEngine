package Internal.Logic;

import Internal.Graphics.Renderer;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public final class Game {
    private static ArrayList<GameObject> objects = new ArrayList<>();
    private static ArrayList<GameObject> addQueue = new ArrayList<>();
    private static ArrayList<GameObject> removeQueue = new ArrayList<>();


    static Renderer window;

    private static long startTime = 100;
    private static float deltaTime = 100;
    private static long frame = 0;

    public static void setup(){
        new Renderer();

        new Thread(() -> {
            Date date = new Date();

            startTime = System.nanoTime();

            while(true){
                deltaTime = (System.nanoTime() - (float)startTime)/1000000000;
                startTime = System.nanoTime();

                Input.update();

                objects.addAll(addQueue);
                objects.removeAll(removeQueue);

                for (GameObject o:addQueue) {
                    o.start();
                }

                addQueue.clear();
                removeQueue.clear();

                for (GameObject o:objects) {
                    o.update();
                }

                window.repaint();

                frame++;
            }
        }).start();
    }

    public static void save(){
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream("objects.txt"));
            o.writeObject(objects);
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(){
        System.out.println("Loading Objects");

        ObjectInputStream o = null;
        try {
            o = new ObjectInputStream(new FileInputStream("objects.txt"));
            try {
                objects = (ArrayList<GameObject>) o.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long getFrame() {
        return frame;
    }

    public static ArrayList<GameObject> getObjects() {
        return objects;
    }

    public static void addQueue(GameObject object){
        addQueue.add(object);
    }

    public static void removeQueue(GameObject object){
        removeQueue.add(object);
    }

    public static float getDeltaTime() {
        return deltaTime;
    }

    public static void setWindow(Renderer window) {
        Game.window = window;
    }
}
