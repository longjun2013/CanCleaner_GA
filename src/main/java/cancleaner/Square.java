package cancleaner;


import java.util.Arrays;
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
        RandomCanPositionsProvider randomCanPositionsProvider = new RandomCanPositionsProvider(square.length * square[0].length / 2, square.length, square[0].length);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                if (square[i][j].hasCan()) {
                    stringBuilder.append("1");
                } else {
                    stringBuilder.append("0");
                }
            }
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }
}
