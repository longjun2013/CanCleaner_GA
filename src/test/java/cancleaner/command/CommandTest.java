package cancleaner.command;

import cancleaner.robot.Position;
import cancleaner.robot.Robot;
import cancleaner.robot.Square;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CommandTest {

    private Square square;

    @Before
    public void setUp() {
        square = new Square(10, 10);
    }

    @Test
    public void should_move_robot_to_south() {
        Robot robot = square.getRobot();
        Command command = new SouthCommand(robot);

        command.execute();

        assertThat(robot.getPosition(), Matchers.is(new Position(1, 0)));
    }

    @Test
    public void should_move_robot_to_east() {
        Robot robot = square.getRobot();
        Command command = new EastCommand(robot);

        command.execute();

        assertThat(robot.getPosition(), is(new Position(0, 1)));
    }

    @Test
    public void should_move_robot_to_north() {
        Robot robot = square.getRobot();
        robot.setPosition(new Position(1, 0));
        Command command = new NorthCommand(robot);

        command.execute();

        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }

    @Test
    public void should_move_robot_to_west() {
        Robot robot = square.getRobot();
        robot.setPosition(new Position(0, 1));
        Command command = new WestCommand(robot);

        command.execute();

        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }

    @Test
    public void should_clear_can() {
        Position position = new Position(0, 0);
        square.setCan(position);
        Robot robot = square.getRobot();
        Command command = new CleanCanCommand(robot);

        command.execute();

        assertThat(square.hasCan(position), is(false));
    }


}
