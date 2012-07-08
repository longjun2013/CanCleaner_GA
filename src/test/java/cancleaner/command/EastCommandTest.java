package cancleaner.command;

import cancleaner.Position;
import cancleaner.Robot;
import cancleaner.Square;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EastCommandTest {

    private Square square;
    private Robot robot;
    private EastCommand eastCommand;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
        eastCommand = new EastCommand(robot);
    }

    @Test
    public void should_lost_5_score_when_move_to_east_and_east_is_wall() {
        robot.setPosition(new Position(0, 9));

        eastCommand.execute();

        assertThat(robot.getScore(), is(-5));
    }

    @Test
    public void should_move_back_when_move_to_east_and_east_is_wall() {
        robot.setPosition(new Position(0, 9));

        eastCommand.execute();

        assertThat(robot.getPosition(), is(new Position(0, 9)));
    }
}
