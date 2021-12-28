package pairmatching.model.courselevelmission.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LevelTest {
    @ParameterizedTest
    @DisplayName("레벨1, 레벨2, 레벨4를 제외한 값으로 레벨을 생성하려고하면 예외를 발생시킨다.(레벨3과 레벨 5에 해당하는 미션은 없다.)")
    @ValueSource(strings = {"레벨3", "레벨5", "레벨6"})
    void evokeExceptionByLevel3OrLevel5(final String valueOf3Or5) {
        assertThatIllegalArgumentException().isThrownBy(() -> Level.of(valueOf3Or5))
                .withMessage("미션을 가진 레벨을 레벨1, 레벨2, 레벨4 뿐입니다.");
    }

}
