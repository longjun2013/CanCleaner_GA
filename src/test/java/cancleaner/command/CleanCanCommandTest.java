package cancleaner.command;

import cancleaner.robot.Position;
import cancleaner.robot.Robot;
import cancleaner.robot.Square;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CleanCanCommandTest {

    private Square square;
    private Robot robot;
    private CleanCanCommand cleanCanCommand;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
        cleanCanCommand = new CleanCanCommand(robot);
    }

    @Test
    public void should_get_10_score_when_clean_can_and_can_is_cleaned() {
        square.setCan(new Position(0, 0));

        cleanCanCommand.execute();

        assertThat(robot.getScore(), is(10));
    }

    @Test
    public void should_lost_1_score_when_clean_can_and_can_is_not_here() {
        square.cleanCan(new Position(0, 0));

        cleanCanCommand.execute();

        assertThat(robot.getScore(), is(-1));
    }
}
