import java.util.BitSet;

/**
 * Created by Incoruptable on 1/26/2017.
 */
public class Translator {

    BitSet bitArray;
    private boolean inverseLeftTrigger;
    private boolean inverseRightTrigger;

    public Translator() {
        inverseLeftTrigger = false;
        inverseRightTrigger = false;
        bitArray = new BitSet(11);
    }

    public void translateLeftBumperValue(boolean pressed) {
        inverseLeftTrigger = pressed;
    }

    public void translateLeftTriggerValue(double value) {
        bitArray.set(Constants.LEFT_SIDE_DIRECTION_INDEX, inverseLeftTrigger);
        bitArray.set(Constants.LEFT_SIDE_SPEED_START_INDEX, Constants.LEFT_SIDE_SPEED_END_INDEX, false);
        if (value == 1) {
            bitArray.set(Constants.LEFT_SIDE_SPEED_START_INDEX, true);
            bitArray.set(3, true);
        } else if (value >= .9) {
            bitArray.set(Constants.LEFT_SIDE_SPEED_START_INDEX, true);
            bitArray.set(Constants.LEFT_SIDE_SPEED_END_INDEX, true);
        } else if (value >= .8) {
            bitArray.set(Constants.LEFT_SIDE_SPEED_START_INDEX, true);
        } else if (value >= .7) {
            bitArray.set(2, Constants.LEFT_SIDE_SPEED_END_INDEX, true);
        } else if (value >= .6) {
            bitArray.set(2, 3, true);
        } else if (value >= .5) {
            bitArray.set(2, true);
            bitArray.set(Constants.LEFT_SIDE_SPEED_END_INDEX, true);
        } else if (value >= .4) {
            bitArray.set(2, true);
        } else if (value >= .3) {
            bitArray.set(3, Constants.LEFT_SIDE_SPEED_END_INDEX, true);
        } else if (value >= .2) {
            bitArray.set(3, true);
        } else if (value >= .1) {
            bitArray.set(Constants.LEFT_SIDE_SPEED_END_INDEX, true);
        } else {
            bitArray.set(Constants.LEFT_SIDE_SPEED_START_INDEX, Constants.RIGHT_SIDE_DIRECTION_INDEX, false);
        }

        System.out.print(bitArray.toString());
        System.out.println();

    }
}