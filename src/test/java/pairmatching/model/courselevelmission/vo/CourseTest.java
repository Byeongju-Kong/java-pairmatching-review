package pairmatching.model.courselevelmission.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CourseTest {
    @Test
    @DisplayName("백엔드 혹은 프론트엔드가 아닌 값으로 Course를 생성하려고 하면 예외를 발생시킨다.")
    void evokeExceptionByWrongCourseInput() {
        String wrongCourseInput = "프론트엔트인가백엔드인가";
        assertThatIllegalArgumentException().isThrownBy(() -> Course.of(wrongCourseInput))
                .withMessage("과정은 백엔드 혹은 프론트엔드 입니다.");
    }
}
