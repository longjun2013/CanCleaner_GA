package cancleaner;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RandomCanPositionsProviderTest {
    @Test
    public void should_get_50_positions() {
        RandomCanPositionsProvider randomCanPositionsProvider = new RandomCanPositionsProvider();

        List<Position> positions = randomCanPositionsProvider.getPositions();

        assertThat(positions.size(), is(50));
    }
}
