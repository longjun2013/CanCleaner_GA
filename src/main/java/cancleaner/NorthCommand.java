package cancleaner;

public class NorthCommand implements Command {
    private Robot robot;

    public NorthCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        Position original = robot.getPosition();
        Position newPosition = new Position(original.getX() - 1, original.getY());
        robot.setPosition(newPosition);
    }
}
