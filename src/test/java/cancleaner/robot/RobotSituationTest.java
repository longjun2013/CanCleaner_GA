package cancleaner.robot;

import cancleaner.robot.RobotSituation;
import org.junit.Test;

import static cancleaner.robot.RobotSituation.CAN;
import static cancleaner.robot.RobotSituation.EMPTY;
import static cancleaner.robot.RobotSituation.WALL;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RobotSituationTest {

    @Test
    public void should_get_robot_situation_code() {
        assertThat(new RobotSituation(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY).getCode(), is(0));
        assertThat(new RobotSituation(WALL, WALL, WALL, WALL, WALL).getCode(),
                is(WALL * 3 * 3 * 3 * 3 + WALL * 3 * 3 * 3 + WALL * 3 * 3 + WALL * 3 + WALL));
        assertThat(new RobotSituation(WALL, EMPTY, CAN, WALL, CAN).getCode(),
                is(WALL * 3 * 3 * 3 * 3 + EMPTY * 3 * 3 * 3 + CAN * 3 * 3 + WALL * 3 + CAN));
    }
}
