package cancleaner.command;

import cancleaner.robot.Robot;

public class NorthCommand implements Command {
    private Robot robot;

    public NorthCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveToNorth();
    }

}
