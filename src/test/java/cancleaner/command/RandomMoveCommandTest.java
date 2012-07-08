package cancleaner.command;

import cancleaner.Square;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RandomMoveCommandTest {

    private Square square;
    private RandomMoveCommand randomMoveCommand;
    private RandomMoveCommandIndexProvider mockRandomMoveCommandIndexProvider;
    private NorthCommand mockNorthCommand;
    private SouthCommand mockSouthCommand;
    private WestCommand mockWestCommand;
    private EastCommand mockEastCommand;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        randomMoveCommand = new RandomMoveCommand(square.getRobot());
        mockRandomMoveCommandIndexProvider = mock(RandomMoveCommandIndexProvider.class);

        mockNorthCommand = mock(NorthCommand.class);
        mockSouthCommand = mock(SouthCommand.class);
        mockWestCommand = mock(WestCommand.class);
        mockEastCommand = mock(EastCommand.class);

        randomMoveCommand.setCommands(ImmutableList.of(
                mockNorthCommand,
                mockSouthCommand,
                mockWestCommand,
                mockEastCommand));
        randomMoveCommand.setRandomMoveCommandIndexProvider(mockRandomMoveCommandIndexProvider);
    }

    @Test
    public void should_move_north_when_signal_from_random_index_is_0() {
        given(mockRandomMoveCommandIndexProvider.getCommandIndex()).willReturn(0);

        randomMoveCommand.execute();

        verify(mockNorthCommand).execute();
    }

    @Test
    public void should_move_south_when_signal_from_random_index_is_1() {
        given(mockRandomMoveCommandIndexProvider.getCommandIndex()).willReturn(1);

        randomMoveCommand.execute();

        verify(mockSouthCommand).execute();
    }

    @Test
    public void should_move_west_when_signal_from_random_index_is_2() {
        given(mockRandomMoveCommandIndexProvider.getCommandIndex()).willReturn(2);

        randomMoveCommand.execute();

        verify(mockWestCommand).execute();
    }

    @Test
    public void should_move_west_when_signal_from_random_index_is_3() {
        given(mockRandomMoveCommandIndexProvider.getCommandIndex()).willReturn(3);

        randomMoveCommand.execute();

        verify(mockEastCommand).execute();
    }
}
