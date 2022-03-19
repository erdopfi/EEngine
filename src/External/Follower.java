package External;

import Internal.Components.Component;
import Internal.Logic.Game;
import Internal.Logic.GameObject;
import Internal.Math.Vector;

public class Follower extends Component {

    private GameObject target;

    private float followSpeed = 0;

    public Follower(float followSpeed) {
        this.followSpeed = followSpeed;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
        if(target == null)
            return;

        gameObject.setPosition(Vector.lerp(gameObject.getPosition(), target.getPosition(), Game.getDeltaTime() * followSpeed));
    }

    public GameObject getTarget() {
        return target;
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }
}
