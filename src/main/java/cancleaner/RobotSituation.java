package cancleaner;

public class RobotSituation {
    public static final int EMPTY = 0;
    public static final int CAN = 1;
    public static final int WALL = 2;

    private int north;
    private int south;
    private int west;
    private int east;
    private int middle;

    public RobotSituation(int north, int south, int west, int east, int middle) {
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
        this.middle = middle;
    }

    public int getNorth() {
        return north;
    }

    public int getSouth() {
        return south;
    }

    public int getWest() {
        return west;
    }

    public int getEast() {
        return east;
    }

    public int getMiddle() {
        return middle;
    }

    public int getCode() {
        return north * 3 * 3 * 3 * 3
                + south * 3 * 3 * 3
                + west * 3 * 3
                + east * 3
                + middle;
    }
}
