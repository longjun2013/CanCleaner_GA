package cancleaner.command;

import cancleaner.robot.Robot;

public class WestCommand implements Command {
    private Robot robot;

    public WestCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveToWest();
    }

}
