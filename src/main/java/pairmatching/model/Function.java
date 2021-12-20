package pairmatching.model;

import java.util.Arrays;

public enum Function {
    MATCH("1"),
    CHECK("2"),
    RESET("3"),
    QUIT("Q");

    private final String value;

    Function(final String value) {
        this.value = value;
    }

    public static Function of(final String userInputValue) {
        return Arrays.stream(values())
                .filter(function -> userInputValue.equals(function.value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 값으로 실행할 수 있는 기능이 없습니다."));
    }
}
