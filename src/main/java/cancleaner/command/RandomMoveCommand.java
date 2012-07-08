package cancleaner.command;

import cancleaner.robot.Robot;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class RandomMoveCommand implements Command {
    private List<Command> commands;
    private RandomMoveCommandIndexProvider randomMoveCommandIndexProvider;

    public RandomMoveCommand(Robot robot) {
        commands = ImmutableList.of(
                new NorthCommand(robot),
                new SouthCommand(robot),
                new WestCommand(robot),
                new EastCommand(robot));
        randomMoveCommandIndexProvider = new RandomMoveCommandIndexProvider();
    }

    @Override
    public void execute() {
        Command command = null;
        switch (randomMoveCommandIndexProvider.getCommandIndex()) {
            case 0:
                command = commands.get(0);
                break;
            case 1:
                command = commands.get(1);
                break;
            case 2:
                command = commands.get(2);
                break;
            case 3:
                command = commands.get(3);
                break;
        }
        command.execute();
    }

    public void setCommands(ImmutableList<Command> commands) {
        this.commands = commands;
    }

    public void setRandomMoveCommandIndexProvider(RandomMoveCommandIndexProvider randomMoveCommandIndexProvider) {
        this.randomMoveCommandIndexProvider = randomMoveCommandIndexProvider;
    }
}
