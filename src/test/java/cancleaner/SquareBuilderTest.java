package cancleaner;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SquareBuilderTest {
    @Test
    public void should_create_square(){
        SquareBuilder squareBuilder = new SquareBuilder(10, 10);

        Assert.assertThat(squareBuilder.getX(), Matchers.is(10));
    }
}
