package pairmatching.model.courselevelmission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.courselevelmission.vo.Course;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CourseLevelMissionTest {
    private final List<String> inputCourseLevelMission = Arrays.asList("백엔드", "레벨1", "자동차경주게임");
    private final CourseLevelMission courseLevelMission = CourseLevelMission.of(inputCourseLevelMission);

    @Test
    @DisplayName("과정을 반환한다.")
    void getCourse() {
        Course course = courseLevelMission.getCourse();
        assertThat(course).isEqualTo(Course.BACK_END);
    }
}