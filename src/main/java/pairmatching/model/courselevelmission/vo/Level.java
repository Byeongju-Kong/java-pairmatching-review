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
        if (isUserInputLevel3OrLevel5(userInputLevelValue)) {
            throw new IllegalArgumentException("레벨 3과 5에 해당하는 미션은 없습니다.");
        }
        return Arrays.stream(values())
                .filter(level -> userInputLevelValue.equals(level.value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("레벨에 대한 입력이 잘못되었습니다."));
    }

    private static boolean isUserInputLevel3OrLevel5(final String userInputLevelValue) {
        return userInputLevelValue.equals(LEVEL3.value) || userInputLevelValue.equals(LEVEL5.value);
    }
}
