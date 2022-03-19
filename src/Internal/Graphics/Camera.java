package Internal.Graphics;

import Internal.Components.Component;
import Internal.Logic.Input;
import Internal.Math.Vector;

import java.awt.event.KeyEvent;

public class Camera extends Component {

    private Vector position = new Vector();

    @Override
    public void start() {
        Renderer.setCamera(this);
    }

    @Override
    public void update() {
        position.x = gameObject.getPosition().x - (float) Renderer.getFrame().getWidth()/2;
        position.y = gameObject.getPosition().y - (float) Renderer.getFrame().getHeight()/2;

        if(Input.isPressed(KeyEvent.VK_F3)){
            Renderer.setDebugging(!Renderer.isDebugging());
        }
    }

    public Vector getPosition(){
        return position;
    }
}
