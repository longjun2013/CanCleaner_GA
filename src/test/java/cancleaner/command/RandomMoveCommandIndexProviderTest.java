package cancleaner.command;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

public class RandomMoveCommandIndexProviderTest {
    @Test
    public void should_get_random_command_index() {
        RandomMoveCommandIndexProvider randomMoveCommandIndexProvider = new RandomMoveCommandIndexProvider();

        assertThat(randomMoveCommandIndexProvider.getCommandIndex(), greaterThanOrEqualTo(0));
        assertThat(randomMoveCommandIndexProvider.getCommandIndex(), lessThanOrEqualTo(3));
    }
}
