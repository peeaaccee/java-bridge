package bridge;

public enum ErrorMessage {
    INPUT_NUMERIC("[ERROR] %d 이상 %d 이하의 숫자만 입력해주세요."),
    INPUT_RANGE("[ERROR] 다리 길이는 %d 이상 %d 이하여야 합니다."),
    WRONG_MOVING("[ERROR] 위로 이동하려면 \"%s\", 아래로 이동하려면 \"%s\"를 입력하세요,"),
    WRONG_COMMAND("[ERROR] 게임을 재시작하려면 \"%s\", 종료하려면 \"%s\"를 입력하세요.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
