package Internal.Components;

import Internal.Logic.GameObject;
import Internal.Math.Vector;

import java.awt.*;

public abstract class Component {
    protected GameObject gameObject;

    public abstract void start();
    public abstract void update();
    protected void destroy(){
        //Do something later on //Still figuring out what exactly
    }

    public void debugVisualize(Graphics g, Vector cameraOffset){};

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
