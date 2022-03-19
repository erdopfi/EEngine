package Internal.Math;

import java.awt.*;
import java.util.Random;

public abstract class CRandom {
    public static Random random = new Random();

    public static Color randomColor(){
        return new Color((int)(Math.random() * 0x1000000));
    }

    public static int intRange(int min, int max){
        return random.nextInt(max + min + 1) - min;
    }
}
