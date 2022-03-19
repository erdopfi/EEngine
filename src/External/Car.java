package External;

import Internal.Components.Component;
import Internal.Graphics.IVisualize;
import Internal.Logic.Game;
import Internal.Logic.Input;
import Internal.Math.CMath;
import Internal.Math.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Car extends Component implements IVisualize {

    private float driveVelocity = 0;
    private float rotation = 0;

    private float driveSpeed;
    private float driveAcceleration;
    private float rotationSpeed;
    private float friction;

    public Car(float driveSpeed, float driveAcceleration, float rotationSpeed, float friction) {
        this.driveSpeed = driveSpeed;
        this.driveAcceleration = driveAcceleration;
        this.rotationSpeed = rotationSpeed;
        this.friction = friction;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
        Vector directionVector = CMath.radianToVector(rotation);
        Vector position = gameObject.getPosition();

        position.x += directionVector.x * Game.getDeltaTime() * driveVelocity;
        position.y += directionVector.y * Game.getDeltaTime() * driveVelocity;

        if(driveVelocity != 0){
            if(Input.isHold(KeyEvent.VK_D)){
                rotation += Game.getDeltaTime() * 5;
            }
            if(Input.isHold(KeyEvent.VK_A)){
                rotation -= Game.getDeltaTime() * 5;
            }
        }

        if(Input.isHold(KeyEvent.VK_W)){
            driveVelocity = CMath.lerp(driveVelocity, driveSpeed, Game.getDeltaTime() * driveAcceleration);
        }else{
        }
        if(Input.isHold(KeyEvent.VK_S)){
            driveVelocity = CMath.lerp(driveVelocity, -driveSpeed /2, Game.getDeltaTime() * driveAcceleration/2);
        }

        driveVelocity = CMath.lerp(driveVelocity, 0, Game.getDeltaTime() * friction);
    }

    @Override
    public void visualize(Graphics graphics, Vector cameraOffset) {

        graphics.setColor(Color.black);

        Graphics2D gg = (Graphics2D) graphics.create();


        Vector position = gameObject.getPosition();
        int x = (int) (position.x - cameraOffset.x);
        int y = (int)(position.y - cameraOffset.y);
        int width = 80;
        int height = 50;

        gg.setColor(Color.black);

        gg.rotate(rotation, x + (float)width/2, y + (float)height/2);
        gg.fillRect(x, y, width, height);
        gg.dispose();

    }
}
