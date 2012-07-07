package cancleaner;

public class SouthCommand implements Command{
    private Robot robot;

    public SouthCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        Position original = robot.getPosition();
        Position newPosition = new Position(original.getX() + 1, original.getY());
        robot.setPosition(newPosition);
    }
}
