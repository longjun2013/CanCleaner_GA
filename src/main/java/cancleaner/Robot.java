package cancleaner;

public class Robot {
    private Position position;
    private Square square;

    public Robot(Position position, Square square) {
        this.position = position;
        this.square = square;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void clearCan() {
        square.cleanCan(position);
    }
}
