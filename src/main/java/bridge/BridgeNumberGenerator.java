package bridge;
// Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate()를 활용한다.
// 클래스의 코드는 변경할 수 없다.

// 다리 칸을 생성하기 위한 Random 값은 아래와 같이 추출: int number = bridgeNumberGenerator.generate();
@FunctionalInterface
public interface BridgeNumberGenerator {

    int generate();
}
