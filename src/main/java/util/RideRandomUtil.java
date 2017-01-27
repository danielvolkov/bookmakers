package util;

/**
 * Created by daniel on 1/26/17.
 */
public class RideRandomUtil {
    private static final int HORSES_IN_RIDE = 5;

    public static int[] horseIdGenerator() {
        int firstId = (int) Math.round(Math.random()*HORSES_IN_RIDE);
        int secondId;
        do {
            secondId = (int) Math.round(Math.random()*HORSES_IN_RIDE);
        }while (firstId == secondId );
        return new int[]{firstId,secondId};
    }
}
