package Internal.Random;

import java.awt.*;
import java.util.Random;

public class CRandom {
    private static Random random = new Random();

    public static Color randomColor(){
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }

    public static int intRange(int min, int max){
        return random.nextInt(max - min) + min;
    }
}
