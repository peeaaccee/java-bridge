package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeRandomNumberGeneratorTest {
    @DisplayName("0과 1 중 랜덤한 숫자를 생성한다.")
    @Test
    void should_ReturnZeroOrOne_When_Generate() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        int randomNumber = bridgeRandomNumberGenerator.generate();
        assertThat(randomNumber).isIn(List.of(0, 1));
    }

}
