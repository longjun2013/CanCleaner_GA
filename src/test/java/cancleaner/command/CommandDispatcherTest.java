package cancleaner.command;

import cancleaner.Position;
import cancleaner.Robot;
import cancleaner.Square;
import com.google.common.collect.ImmutableList;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandDispatcherTest {

    private Square square;
    private Robot robot;
    private CommandDispatcher commandDispatcher;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
        commandDispatcher = new CommandDispatcher(robot);
    }

    @Test
    public void should_move_north_when_receive_0() {
        robot.setPosition(new Position(1, 0));

        commandDispatcher.execute(0);

        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }

    @Test
    public void should_move_south_when_receive_1() {
        commandDispatcher.execute(1);

        assertThat(robot.getPosition(), is(new Position(1, 0)));
    }

    @Test
    public void should_move_west_when_receive_2() {
        robot.setPosition(new Position(0, 1));

        commandDispatcher.execute(2);

        assertThat(robot.getPosition(), is(new Position(0, 0)));
    }

    @Test
    public void should_move_east_when_receive_3() {
        commandDispatcher.execute(3);

        assertThat(robot.getPosition(), is(new Position(0, 1)));
    }

    @Test
    public void should_clean_can_when_receive_4() {
        square.setCan(new Position(0, 0));

        commandDispatcher.execute(4);

        assertThat(square.hasCan(new Position(0, 0)), is(false));
    }

    @Test
    public void should_random_move_when_receive_5() {
        RandomMoveCommand randomMoveCommand = mock(RandomMoveCommand.class);
        commandDispatcher.setCommands(ImmutableList.of(
                mock(Command.class),
                mock(Command.class),
                mock(Command.class),
                mock(Command.class),
                mock(Command.class),
                randomMoveCommand
        ));
        commandDispatcher.execute(5);

        verify(randomMoveCommand).execute();
    }

}
