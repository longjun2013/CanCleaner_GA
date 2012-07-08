package cancleaner.command;

import cancleaner.robot.Position;
import cancleaner.robot.Robot;
import cancleaner.robot.Square;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NorthCommandTest {
    private Square square;
    private Robot robot;
    private NorthCommand northCommand;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
        northCommand = new NorthCommand(robot);
    }

    @Test
    public void should_lost_5_score_when_move_to_north_and_north_is_wall() {
        northCommand.execute();

        assertThat(robot.getScore(), is(-5));
    }

    @Test
    public void should_move_back_when_move_to_east_and_east_is_wall() {
        northCommand.execute();

        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }
}
