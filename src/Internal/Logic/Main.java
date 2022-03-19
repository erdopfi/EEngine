package Internal.Logic;

import External.Follower;
import External.SinusMover;
import External.Car;
import Internal.Collision.Collider;
import Internal.Components.RectangleVisualizer;
import Internal.Graphics.Camera;
import Internal.Random.CRandom;

public class Main {
    public static void main(String[] args) {
        testSetup();

        Game.setup(); //Do not delete, otherwise the game won't start
    }

    private static void testSetup() {
        for(int i = 0; i < 10000; i++){
            int random = CRandom.intRange(25, 100);

            GameObject gO = new GameObject(50, i * 15);
            gO.addComponent(new RectangleVisualizer(random,random, CRandom.randomColor()));
            gO.addComponent(new Collider(random, random));
            gO.addComponent(new SinusMover(CRandom.intRange(2, 6), CRandom.intRange(25, 100), CRandom.intRange(0, 1000)));
        }

        GameObject gO = new GameObject(50, 50);
        gO.addComponent(new Car(1000, 10, 5, 3));

        GameObject cameraObject = new GameObject();
        cameraObject.addComponent(new Camera());
        Follower follower = new Follower(5);
        follower.setTarget(gO);
        cameraObject.addComponent(follower);
    }
}
