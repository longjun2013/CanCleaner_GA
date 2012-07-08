package cancleaner.command;

import cancleaner.robot.Robot;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class CommandDispatcher {

    private List<Command> commands;

    public CommandDispatcher(Robot robot) {
        commands = ImmutableList.of(
                new NorthCommand(robot),
                new SouthCommand(robot),
                new WestCommand(robot),
                new EastCommand(robot),
                new CleanCanCommand(robot),
                new RandomMoveCommand(robot)
        );
    }

    public void execute(int signal) {
        switch (signal) {
            case 0:
                commands.get(0).execute();
                break;
            case 1:
                commands.get(1).execute();
                break;
            case 2:
                commands.get(2).execute();
                break;
            case 3:
                commands.get(3).execute();
                break;
            case 4:
                commands.get(4).execute();
                break;
            case 5:
                commands.get(5).execute();
                break;
        }
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
