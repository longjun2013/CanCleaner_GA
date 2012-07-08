package cancleaner.robot;


public class Robot {
    private Position position;
    private Square square;
    private int score;

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
        if (square.hasCan(position)) {
            score += 10;
        } else {
            score += -1;
        }
        square.cleanCan(position);
    }

    public RobotSituation getSituation() {
        return new RobotSituation(getNorthSituation(), getSouthSituation(), getWestSituation(), getEastSituation(), getMiddleSituation());
    }

    private int getMiddleSituation() {
        if (square.hasCan(position)) {
            return RobotSituation.CAN;
        }
        return RobotSituation.EMPTY;
    }

    private int getEastSituation() {
        Position eastPosition = getEastPosition(position);
        if (square.isWall(eastPosition)) {
            return RobotSituation.WALL;
        }
        if (square.hasCan(eastPosition)) {
            return RobotSituation.CAN;
        }
        return RobotSituation.EMPTY;
    }

    public Position getEastPosition(Position currentPosition) {
        return new Position(currentPosition.getX(), currentPosition.getY() + 1);
    }

    private int getWestSituation() {
        Position westPosition = getWestPosition(position);
        if (square.isWall(westPosition)) {
            return RobotSituation.WALL;
        }
        if (square.hasCan(westPosition)) {
            return RobotSituation.CAN;
        }
        return RobotSituation.EMPTY;
    }

    public Position getWestPosition(Position currentPosition) {
        return new Position(currentPosition.getX(), currentPosition.getY() - 1);
    }

    private int getSouthSituation() {
        Position southPosition = getSouthPosition(position);
        if (square.isWall(southPosition)) {
            return RobotSituation.WALL;
        }
        if (square.hasCan(southPosition)) {
            return RobotSituation.CAN;
        }
        return RobotSituation.EMPTY;
    }

    public Position getSouthPosition(Position currentPosition) {
        return new Position(currentPosition.getX() + 1, currentPosition.getY());
    }

    private int getNorthSituation() {
        Position northPosition = getNorthPosition(position);
        if (square.isWall(northPosition)) {
            return RobotSituation.WALL;
        }
        if (square.hasCan(northPosition)) {
            return RobotSituation.CAN;
        }
        return RobotSituation.EMPTY;
    }

    public Position getNorthPosition(Position currentPosition) {
        return new Position(currentPosition.getX() - 1, currentPosition.getY());
    }

    public void moveToEast() {
        Position newPosition = getEastPosition(position);

        if (square.isWall(newPosition)) {
            score += -5;
            return;
        }
        setPosition(newPosition);
    }

    public void moveToNorth() {
        Position newPosition = getNorthPosition(position);

        if (square.isWall(newPosition)) {
            score += -5;
            return;
        }
        setPosition(newPosition);
    }

    public void moveToSouth() {
        Position newPosition = getSouthPosition(position);

        if (square.isWall(newPosition)) {
            score += -5;
            return;
        }
        setPosition(newPosition);
    }

    public void moveToWest() {
        Position newPosition = getWestPosition(position);

        if (square.isWall(newPosition)) {
            score += -5;
            return;
        }
        setPosition(newPosition);
    }

    public int getScore() {
        return score;
    }
}
