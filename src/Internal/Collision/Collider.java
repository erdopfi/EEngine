package Internal.Collision;

import Internal.Components.Component;
import Internal.Math.Vector;

import java.awt.*;

public class Collider extends Component {

    public Vector size = new Vector();
    public Vector offset = new Vector();

    public Collider(float sizeX, float sizeY){
        size.x = sizeX;
        size.y = sizeY;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void debugVisualize(Graphics g, Vector cameraOffset) {
        g.setColor(Color.red);
        g.drawRect((int) (gameObject.getPosition().x - cameraOffset.x), (int) (gameObject.getPosition().y - cameraOffset.y), (int) size.x, (int) size.y);
    }
}
