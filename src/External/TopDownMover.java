package External;

import Internal.Components.Component;
import Internal.Logic.Game;
import Internal.Logic.Input;
import Internal.Math.Vector;

import java.awt.event.KeyEvent;

public class TopDownMover extends Component {

    private final float speed;
    private Vector inputVector = new Vector();

    public TopDownMover(float speed) {
        this.speed = speed;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
        inputVector.x = 0;
        inputVector.y = 0;

        if(Input.isHold(KeyEvent.VK_W)){
            //moveX = Game.getDeltaTime() * speed;
            inputVector.y -= 1;
        }

        if(Input.isHold(KeyEvent.VK_S)){
            //moveX = Game.getDeltaTime() * speed;
           inputVector.y += 1;
        }

        if(Input.isHold(KeyEvent.VK_A)){
            //moveX = Game.getDeltaTime() * speed;
            inputVector.x -= 1;
        }

        if(Input.isHold(KeyEvent.VK_D)){
            //moveX = Game.getDeltaTime() * speed;
            inputVector.x += 1;
        }

        inputVector.normalize();

        Vector position = gameObject.getPosition();
        position.x += inputVector.x * Game.getDeltaTime() * speed;
        position.y += inputVector.y * Game.getDeltaTime() * speed;
    }
}
