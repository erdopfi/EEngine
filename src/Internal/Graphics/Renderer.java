package Internal.Graphics;

import Internal.Logic.Game;
import Internal.Logic.GameObject;
import Internal.Logic.Input;
import Internal.Math.Vector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class Renderer extends JPanel {

    private static boolean debugging;

    private static Camera camera;

    private static JFrame frame;

    private static float drawingDistance = 1500;

    public Renderer() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(0,0,1000,1000);
        frame.setLayout(null);
        frame.setContentPane(this);

        Input input = new Input();
        frame.addKeyListener(input);
        frame.addMouseListener(input);
        frame.addMouseMotionListener(input);

        setVisible(true);
        setBounds(0,0,1000,1000);
        setLayout(null);

        Game.setWindow(this);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static Camera getCamera() {
        return camera;
    }

    public static void setCamera(Camera camera) {
        Renderer.camera = camera;
    }

    public static boolean isDebugging() {
        return debugging;
    }

    public static void setDebugging(boolean debugging) {
        Renderer.debugging = debugging;
    }

    public static float getDrawingDistance() {
        return drawingDistance;
    }

    public static void setDrawingDistance(float drawingDistance) {
        Renderer.drawingDistance = drawingDistance;
    }

    @Override
    public synchronized void repaint() {
        super.repaint();
    }

    @Override
    public synchronized void paint(Graphics graphics) {
        super.paint(graphics);

        if(camera == null){
            int width = frame.getWidth();
            int height = frame.getHeight();

            graphics.fillRect(0,0, width, height);
            graphics.setColor(Color.white);
            graphics.drawString("Camera not set", width/2, height/2);
            return;
        }

        ArrayList<GameObject> objects = (ArrayList<GameObject>) Game.getObjects().clone(); //Need to change that, maybe for loop?
        HashMap<GameObject, Boolean> gameObjectDistanceToCamera = new HashMap<>();

        Vector cameraPosition = camera.getPosition();

        int drawnObjectsCount = 0;
        for (GameObject o:objects) {
            float distance = Vector.distance(o.getPosition(), camera.getGameObject().getPosition());
            boolean getsDrawn = distance < drawingDistance;
            gameObjectDistanceToCamera.put(o, getsDrawn);

            if(getsDrawn)
                drawnObjectsCount++;
        }

        for (GameObject o: objects) {
            if(!gameObjectDistanceToCamera.get(o))
                continue;

            o.visualize(graphics, cameraPosition);
        }

        if(debugging){
            for (GameObject o:objects) {
                if(!gameObjectDistanceToCamera.get(o))
                    continue;

                o.debugVisualize(graphics, cameraPosition);
            }

            graphics.setColor(Color.black);
            graphics.drawString("FPS (broken right now): " + (1 / Game.getDeltaTime()), 20, 20);
            graphics.drawString("Objects: " + Game.getObjects().size(), 20, 40);
            graphics.drawString("Drawn Objects: " + drawnObjectsCount, 20, 60);
            graphics.drawString("Drawing Distance: " + (int) drawingDistance, 20, 80);
        }
    }
}
