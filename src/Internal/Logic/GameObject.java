package Internal.Logic;

import Internal.Collision.Collider;
import Internal.Components.Component;
import Internal.Graphics.IVisualize;
import Internal.Math.Vector;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class GameObject implements Serializable {
    private Vector position = new Vector();

    private ArrayList<Internal.Components.Component> components = new ArrayList<>();

    private ArrayList<IVisualize> visualizers = new ArrayList<>();
    private ArrayList<Collider> colliders = new ArrayList<>();

    public GameObject(){
        Game.addQueue(this);
    }

    public GameObject(float x, float y) {
        this();
        position.x = x;
        position.y = y;
    }

    public <T> T getComponent(Class<T> c){
        for (Component component:components) {
            if(c.isInstance(component)){
                return (T)component;
            }
            for (Class interf : component.getClass().getInterfaces()) {
                if (interf.isInstance(c)) {
                    return (T)interf;
                }
            }
        }
        return null;
    }

    public void addComponent(Internal.Components.Component component){
        component.setGameObject(this);

        if(!components.contains(component)){
            components.add(component);

            if(component instanceof IVisualize)
                visualizers.add((IVisualize) component);

            if(component instanceof Collider)
                colliders.add((Collider) component);
        }
    }

    public void removeComponent(Internal.Components.Component component){
        components.remove(component);

        if(component instanceof IVisualize)
            visualizers.remove((IVisualize) component);

        if(component instanceof Collider)
            colliders.remove((Collider) component);
    }

    public void start(){
        for (Internal.Components.Component c:components) {
            c.start();
        }
    }

    public void update(){
        for (Component c:components) {
            c.update();
        }
    }

    public void visualize(Graphics g, Vector cameraOffset){
        for (IVisualize v:visualizers) {
            v.visualize(g, cameraOffset);
        }
    }

    public void debugVisualize(Graphics g, Vector cameraOffset){
        for (Component c:components) {
            c.debugVisualize(g, cameraOffset);
        }
        g.drawString((int)position.x + " / " + (int)position.y, (int) (position.x - cameraOffset.x), (int) (position.y - cameraOffset.y));
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public static <T> T findComponent(Class sClass){
        for (GameObject o:Game.getObjects()) {
            T component = (T) o.getComponent(sClass);
            if(component != null)
                return component;
        }
        return null;
    }
}
