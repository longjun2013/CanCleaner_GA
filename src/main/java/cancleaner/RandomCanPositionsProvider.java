package cancleaner;

import java.util.ArrayList;
import java.util.List;

public class RandomCanPositionsProvider {
    List<Position> positions;

    public RandomCanPositionsProvider() {
        positions = new ArrayList<Position>();
    }

    public List<Position> getPositions() {
        while (positions.size() < 50) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            if (!positions.contains(new Position(x, y))) {
                positions.add(new Position(x, y));
            }
        }
        return positions;
    }
}
