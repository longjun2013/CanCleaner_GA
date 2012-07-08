package cancleaner;

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
        Situation situation = robot.getSituation();
        assertThat(situation.getNorth(), is(Situation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_north() {
        robot.setPosition(new Position(1, 0));
        square.setCan(new Position(0, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getNorth(), is(Situation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_north() {
        robot.setPosition(new Position(1, 0));
        square.cleanCan(new Position(0, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getNorth(), is(Situation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_wall_in_south() {
        robot.setPosition(new Position(9, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getSouth(), is(Situation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_south() {
        square.setCan(new Position(1, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getSouth(), is(Situation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_south() {
        square.cleanCan(new Position(1, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getSouth(), is(Situation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_wall_in_west() {
        Situation situation = robot.getSituation();
        assertThat(situation.getWest(), is(Situation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_west() {
        robot.setPosition(new Position(0, 1));
        square.setCan(new Position(0, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getWest(), is(Situation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_west() {
        robot.setPosition(new Position(0, 1));
        square.cleanCan(new Position(0, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getWest(), is(Situation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_wall_in_east() {
        robot.setPosition(new Position(0, 9));

        Situation situation = robot.getSituation();
        assertThat(situation.getEast(), is(Situation.WALL));
    }

    @Test
    public void should_get_current_situation_with_can_in_east() {
        square.setCan(new Position(0, 1));

        Situation situation = robot.getSituation();
        assertThat(situation.getEast(), is(Situation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_east() {
        square.cleanCan(new Position(0, 1));

        Situation situation = robot.getSituation();
        assertThat(situation.getEast(), is(Situation.EMPTY));
    }

    @Test
    public void should_get_current_situation_with_can_in_middle() {
        square.setCan(new Position(0, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getMiddle(), is(Situation.CAN));
    }

    @Test
    public void should_get_current_situation_with_empty_in_middle() {
        square.cleanCan(new Position(0, 0));

        Situation situation = robot.getSituation();
        assertThat(situation.getMiddle(), is(Situation.EMPTY));
    }
}
