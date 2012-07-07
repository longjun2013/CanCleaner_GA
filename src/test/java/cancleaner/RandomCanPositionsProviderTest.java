package cancleaner;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

public class RandomCanPositionsProviderTest {

    private RandomCanPositionsProvider randomCanPositionsProvider;
    private List<Position> positions;

    @Before
    public void setUp() {
        randomCanPositionsProvider = new RandomCanPositionsProvider(50, 10, 10);
        positions = randomCanPositionsProvider.getPositions();
    }

    @Test
    public void should_get_half_can_positions_counts_in_square() {
        assertThat(positions.size(), is(50));
    }

    @Test
    public void should_get_all_can_positions_within_square() {
        for (Position position:positions){
            assertThat(position.getX(),lessThanOrEqualTo(10-1));
            assertThat(position.getY(),lessThanOrEqualTo(10-1));
        }
    }
}
