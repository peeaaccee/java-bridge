package bridge;

import java.text.MessageFormat;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Result result;
    private final Position position;
    int count = 0;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        result = new Result(bridge.size());
        position = new Position(bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        increase();
        Key answer = bridge.get(position.getNext());
        if (Key.matchUp(input)) {
            result.handleUpBridge(answer, position);
            return;
        }
        result.handleDownBridge(answer, position);
    }
    void increase() {
        count++;
    }

    int getPosition() {
        return position.getPosition();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.clear();
        position.clear();
        clear();
    }

    void clear() {
        count = 0;
    }

    boolean isFail() {
        return !position.arrive();
    }

    boolean canMove() {
        return position.isNotArrive() && position.isNotReset();
    }

    public String printGameResult() {
        return MessageFormat.format("\n최종 게임 결과\n{0}\n{1}", this, result);
    }

    @Override
    public String toString() {
        return result.printStatus(count);
    }
}
