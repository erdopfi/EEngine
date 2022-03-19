package External;

import Internal.Components.Component;
import Internal.Logic.Game;

public class SinusMover extends Component {
    private float speed;
    private float amplitude;
    private float offset;

    private double adder = 0;

    public SinusMover(float speed, float amplitude, float offset) {
        this(speed, amplitude);
        this.offset = offset;
    }

    public SinusMover(float speed, float amplitude) {
        this.speed = speed;
        this.amplitude = amplitude;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
        adder += Game.getDeltaTime() * speed;

        gameObject.getPosition().x = (float) Math.sin(adder) * amplitude + offset;
    }
}
