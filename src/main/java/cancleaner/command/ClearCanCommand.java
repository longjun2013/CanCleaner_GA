package cancleaner.command;

import cancleaner.Robot;

public class ClearCanCommand implements Command {
    private Robot robot;

    public ClearCanCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.clearCan();
    }
}