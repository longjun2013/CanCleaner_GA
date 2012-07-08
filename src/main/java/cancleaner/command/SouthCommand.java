package cancleaner.command;

import cancleaner.robot.Robot;

public class SouthCommand implements Command{
    private Robot robot;

    public SouthCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.moveToSouth();
    }

}
