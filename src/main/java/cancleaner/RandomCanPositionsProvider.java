package cancleaner;

import java.util.ArrayList;
import java.util.List;

public class RandomCanPositionsProvider {
    List<Position> positions;
    private int counts;
    private int x;
    private int y;

    public RandomCanPositionsProvider(int counts, int x, int y) {
        positions = new ArrayList<Position>();
        this.counts = counts;
        this.x = x;
        this.y = y;
    }

    public List<Position> getPositions() {
        while (positions.size() < counts) {
            int xIndex = (int) (Math.random() * x);
            int yIndex = (int) (Math.random() * y);
            if (!positions.contains(new Position(xIndex, yIndex))) {
                positions.add(new Position(xIndex, yIndex));
            }
        }
        return positions;
    }
}
