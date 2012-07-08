package cancleaner.command;

import cancleaner.Position;
import cancleaner.Robot;
import cancleaner.Square;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SouthCommandTest {
    private Square square;
    private Robot robot;
    private SouthCommand southCommand;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
        southCommand = new SouthCommand(robot);
    }

    @Test
    public void should_lost_5_score_when_move_to_south_and_south_is_wall() {
        robot.setPosition(new Position(9, 0));

        southCommand.execute();

        assertThat(robot.getScore(), is(-5));
    }

    @Test
    public void should_move_back_when_move_to_south_and_south_is_wall() {
        robot.setPosition(new Position(9, 0));

        southCommand.execute();

        assertThat(robot.getPosition(), is(new Position(9, 0)));
    }

}
