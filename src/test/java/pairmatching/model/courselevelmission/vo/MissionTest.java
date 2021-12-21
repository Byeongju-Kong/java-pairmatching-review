package pairmatching.model.courselevelmission.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MissionTest {
    @ParameterizedTest
    @DisplayName("잘못된 이름으로 미션을 생성하거나 미션이름과 레벨이 맞지 않으면 예외를 발생시킨다.")
    @CsvSource({"도둑잡기, LEVEL2", "자동차경주게임, LEVEL4"})
    void evokeExceptionByWrongMissionName(final String missionName, final Level level) {
        assertThatIllegalArgumentException().isThrownBy(() -> Mission.of(missionName, level))
                .withMessage("등록되지 않은 미션의 이름이거나 미션과 레벨이 맞지 않습니다.");
    }
}
