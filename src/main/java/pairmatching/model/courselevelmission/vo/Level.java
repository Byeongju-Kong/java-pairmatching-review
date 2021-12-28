package pairmatching.model.courselevelmission.vo;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String value;

    Level(final String value) {
        this.value = value;
    }

    public static Level of(final String userInputLevelValue) {
        return Arrays.stream(values())
                .filter(level -> userInputLevelValue.equals(level.value))
                .filter(level -> !userInputLevelValue.equals(LEVEL3.value))
                .filter(level -> !userInputLevelValue.equals(LEVEL5.value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("미션을 가진 레벨을 레벨1, 레벨2, 레벨4 뿐입니다."));
    }
}
