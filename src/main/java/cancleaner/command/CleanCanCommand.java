package cancleaner.command;

import cancleaner.robot.Robot;

public class CleanCanCommand implements Command {
    private Robot robot;

    public CleanCanCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.clearCan();
    }
}
