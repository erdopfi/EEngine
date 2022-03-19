package Internal.Components;

import Internal.Graphics.IVisualize;
import Internal.Math.Vector;

import java.awt.*;

public class RectangleVisualizer extends Component implements IVisualize {

    private Vector size = new Vector();
    private Color color = Color.black;

    public RectangleVisualizer(float x, float y, Color color){
        this(x, y);
        this.color = color;
    }

    public RectangleVisualizer(float x, float y){
        size.x = x;
        size.y = y;
    }

    @Override
    public void visualize(Graphics graphics, Vector cameraOffset) {
        graphics.setColor(color);
        Vector position = gameObject.getPosition();

        int x = (int) (position.x - cameraOffset.x);
        int y = (int)(position.y - cameraOffset.y);
        graphics.fillRect(x, y, (int)size.x, (int)size.y);
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }
}
