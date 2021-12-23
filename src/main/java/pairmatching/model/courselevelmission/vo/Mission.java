package pairmatching.model.courselevelmission.vo;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    NUMBER_BASEBALL("숫자야구게임", Level.LEVEL1),

    CART("장바구니", Level.LEVEL2),
    PAY("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),

    ENHANCING_PERFORMANCE("성능개선", Level.LEVEL4),
    RELEASE("배포", Level.LEVEL4);


    private final String name;
    private final Level level;

    Mission(final String name, final Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission of(final String userInputNameValue, final Level userInputLevelValue) {
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(userInputNameValue) && mission.level == userInputLevelValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 미션의 이름이거나 미션과 레벨이 맞지 않습니다."));
    }
}
