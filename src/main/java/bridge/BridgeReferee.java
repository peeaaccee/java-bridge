package bridge;

import java.util.List;

import static bridge.BridgeRule.INITIAL_LOCATION;
import static bridge.BridgeRule.MOVING_DISTANCE;
import static bridge.GameStatus.*;

public class BridgeReferee {

    private final List<String> bridge;
    private int location;

    public BridgeReferee(List<String> bridge) {
        this.bridge = bridge;
        resetLocation();
    }

    public GameStatus judge(String moving) {
        if (isCorrect(moving)) {
            this.location += MOVING_DISTANCE;
            if (isCrossCompletely()) {
                return END;
            }
            return ON_WAY;
        }
        return FAIL;
    }

    public boolean isCrossCompletely() {
        int bridgeSize = bridge.size();
        return bridgeSize == location;
    }

    public void resetLocation() {
        this.location = INITIAL_LOCATION;
    }

    private boolean isCorrect(String moving) {
        String correctMoving = bridge.get(location);
        return correctMoving.equals(moving);
    }
}
