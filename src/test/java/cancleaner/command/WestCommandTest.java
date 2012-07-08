package cancleaner.command;

import cancleaner.robot.Position;
import cancleaner.robot.Robot;
import cancleaner.robot.Square;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WestCommandTest {
    private Square square;
    private Robot robot;
    private WestCommand westCommand;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
        westCommand = new WestCommand(robot);
    }

    @Test
    public void should_lost_5_score_when_move_to_west_and_west_is_wall() {
        westCommand.execute();

        assertThat(robot.getScore(), is(-5));
    }

    @Test
    public void should_move_back_when_move_to_west_and_west_is_wall() {
        westCommand.execute();

        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }

}
