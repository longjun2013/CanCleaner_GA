package cancleaner.robot;

import cancleaner.robot.Position;
import cancleaner.robot.Robot;
import cancleaner.robot.RobotSituation;
import cancleaner.robot.Square;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RobotTest {

    private Square square;
    private Robot robot;

    @Before
    public void setUp() {
        square = new Square(10, 10);
        robot = square.getRobot();
    }

    @Test
    public void should_get_current_situation_with_wall_in_north() {
        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getNorth(), is(RobotSituation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_north() {
        robot.setPosition(new Position(1, 0));
        square.setCan(new Position(0, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getNorth(), is(RobotSituation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_north() {
        robot.setPosition(new Position(1, 0));
        square.cleanCan(new Position(0, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getNorth(), is(RobotSituation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_wall_in_south() {
        robot.setPosition(new Position(9, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getSouth(), is(RobotSituation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_south() {
        square.setCan(new Position(1, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getSouth(), is(RobotSituation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_south() {
        square.cleanCan(new Position(1, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getSouth(), is(RobotSituation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_wall_in_west() {
        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getWest(), is(RobotSituation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_west() {
        robot.setPosition(new Position(0, 1));
        square.setCan(new Position(0, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getWest(), is(RobotSituation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_west() {
        robot.setPosition(new Position(0, 1));
        square.cleanCan(new Position(0, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getWest(), is(RobotSituation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_wall_in_east() {
        robot.setPosition(new Position(0, 9));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getEast(), is(RobotSituation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_east() {
        square.setCan(new Position(0, 1));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getEast(), is(RobotSituation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_east() {
        square.cleanCan(new Position(0, 1));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getEast(), is(RobotSituation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_can_in_middle() {
        square.setCan(new Position(0, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getMiddle(), is(RobotSituation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_middle() {
        square.cleanCan(new Position(0, 0));

        RobotSituation robotSituation = robot.getSituation();
        assertThat(robotSituation.getMiddle(), is(RobotSituation.EMPTY));
    }
}
