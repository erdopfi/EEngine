package Internal.Math;

import java.io.Serializable;

public class Vector implements Serializable {
    public float x,y;

    public static final Vector zero = new Vector(0,0);

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public void normalize(){
        if(x == 0 && y == 0)
            return;
        double difference = Math.sqrt(x*x + y*y);
        x /= difference;
        y /= difference;
    }

    public static Vector lerp(Vector vectorA, Vector vectorB, float t){
        Vector lerpVector = new Vector();
        lerpVector.x = CMath.lerp(vectorA.x, vectorB.x, t);
        lerpVector.y = CMath.lerp(vectorA.y, vectorB.y, t);

        return lerpVector;
    }

    public static float distance(Vector vectorA, Vector vectorB){
        return (float) Math.sqrt(Math.pow(vectorB.x - vectorA.x, 2) + Math.pow(vectorB.y - vectorA.y, 2));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
