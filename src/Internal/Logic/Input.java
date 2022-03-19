package Internal.Logic;

import Internal.Logic.Game;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Input implements MouseListener, MouseMotionListener, KeyListener {
    public static HashMap<Integer, Long> pressedCodes = new HashMap<Integer, Long>();

    public static ArrayList<Integer> addQueue = new ArrayList<>();
    public static ArrayList<Integer> removeQueue = new ArrayList<>();

    //Constants
    public static final int MBLeft = 500;

    public static boolean isHold(int key){
        return pressedCodes.containsKey(key);
    }

    public static boolean isPressed(int key){
        if(pressedCodes.containsKey(key)){
            return pressedCodes.get(key) == Game.getFrame();
        }
        return false;
    }

    public static void update(){
        for (Integer key:(ArrayList<Integer>) addQueue.clone()) {
            if(!pressedCodes.containsKey(key)){
                pressedCodes.put(key, Game.getFrame());
            }
        }
        for (Integer key:(ArrayList<Integer>) removeQueue.clone()) {
            pressedCodes.remove(key);
        }

        addQueue.clear();
        removeQueue.clear();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if(!addQueue.contains(key)){
            addQueue.add(key);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if(!removeQueue.contains(key)){
            removeQueue.add(key);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
