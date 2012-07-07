package cancleaner;


import java.util.List;

public class Square {

    private final Grid[][] square;
    private final Robot robot;

    public Square(int x, int y) {
        square = new Grid[x][y];
        initGrids();
        robot = new Robot(new Position(0, 0));
    }

    private void initGrids() {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                square[i][j] = new Grid();
            }
        }
        initGirdCans();
    }

    private void initGirdCans() {
        RandomCanPositionsProvider randomCanPositionsProvider = new RandomCanPositionsProvider();
        List<Position> positions = randomCanPositionsProvider.getPositions();
        for (Position position : positions) {
            square[position.getX()][position.getY()].setHasCan(true);
        }
    }

    public int getXLength() {
        return square.length;
    }

    public int getYLength() {
        return square[0].length;
    }

    public Robot getRobot() {
        return robot;
    }

    public int getCountsWithCan() {
        int count = 0;
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                if (square[i][j].hasCan()) {
                    count++;
                }
            }
        }
        return count;
    }
}
