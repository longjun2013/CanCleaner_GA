package cancleaner.robot;

import cancleaner.robot.Position;
import cancleaner.robot.Robot;
import cancleaner.robot.Square;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

    private Square square;

    @Before
    public void setUp() {
        square = new Square(10, 10);
    }

    @Test
    public void should_create_square() {
        assertThat(square.getXLength(), is(10));
        assertThat(square.getYLength(), is(10));
    }

    @Test
    public void should_create_robot_with_place_0_0() {
        Robot robot = square.getRobot();
        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }

    @Test
    public void should_generate_half_grids_with_can() {
        System.out.println(square);
        assertThat(square.getCountsWithCan(), is(50));
    }
}
