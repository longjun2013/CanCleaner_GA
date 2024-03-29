package cancleaner.command;

import cancleaner.robot.Robot;

public class EastCommand implements Command {
    private Robot robot;

    public EastCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveToEast();
    }

}
