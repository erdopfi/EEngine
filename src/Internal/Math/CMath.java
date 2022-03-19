package Internal.Math;

public abstract class CMath {
    public static float lerp(float start, float end, float t){
        return start + (end - start) * t;
    }

    public static Vector radianToVector(float radian)
    {
        return new Vector((float) Math.cos(radian), (float) Math.sin(radian));
    }
}
