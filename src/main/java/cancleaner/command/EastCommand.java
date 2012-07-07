package cancleaner.command;

import cancleaner.Position;
import cancleaner.Robot;

public class EastCommand implements Command {
    private Robot robot;

    public EastCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        Position original = robot.getPosition();
        Position newPosition = new Position(original.getX(), original.getY()+1);
        robot.setPosition(newPosition);
    }
}