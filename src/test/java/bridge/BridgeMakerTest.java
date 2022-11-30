package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Moving.LOWER_SIDE;
import static bridge.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;


public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> movingValues = List.of(UPPER_SIDE, LOWER_SIDE);

    @DisplayName("입력 길이에 맞는 다리를 생성한다.")
    @Nested
    class MakeBridge {

        @DisplayName("7 입력 -> 길이가 7인 리스트 생성")
        @Test
        void should_HaveCorrectLength_When_CreateBridge() {
            int inputLength = 7;
            List<String> bridge = bridgeMaker.makeBridge(inputLength);
            assertThat(bridge).hasSize(inputLength);
        }

        @DisplayName("다리 생성 -> 각 요소가 올바른 값을 가지고 있음")
        @Test
        void should_HaveCorrectMoving_When_CreateBridge() {
            List<String> bridge = bridgeMaker.makeBridge(20);
            for (String moving: bridge) {
                assertThat(moving).isIn(movingValues);
            }
        }
    }

}
