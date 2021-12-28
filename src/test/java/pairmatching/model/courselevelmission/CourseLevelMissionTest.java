package pairmatching.model.courselevelmission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.model.courselevelmission.vo.Course;
import pairmatching.model.courselevelmission.vo.Level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL1;

class CourseLevelMissionTest {
    private final List<String> inputCourseLevelMission = Arrays.asList("백엔드", "레벨1", "자동차경주");
    private final CourseLevelMission courseLevelMission = CourseLevelMission.of(inputCourseLevelMission);

    @Test
    @DisplayName("과정을 반환한다.")
    void getCourse() {
        Course course = courseLevelMission.getCourse();
        assertThat(course).isEqualTo(Course.BACK_END);
    }

    @Test
    @DisplayName("레벨을 반환한다.")
    void getLevel() {
        Level level = courseLevelMission.getLevel();
        assertThat(level).isEqualTo(LEVEL1);
    }

    @ParameterizedTest
    @DisplayName("과정, 레벨, 미션을 기준으로 동등성을 반환한다.")
    @MethodSource("provideAnotherCourseLevelMission")
    void equals(final List<String> another, final boolean expected) {
        CourseLevelMission anotherCourseLevelMission = CourseLevelMission.of(another);
        boolean actual = courseLevelMission.equals(anotherCourseLevelMission);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("과정, 레벨, 미션을 기준으로 해시코드를 반환한다.")
    @MethodSource("provideAnotherCourseLevelMission")
    void hashCode(final List<String> another, final boolean expected) {
        CourseLevelMission anotherCourseLevelMission = CourseLevelMission.of(another);
        int courseLevelMissionHashCode = courseLevelMission.hashCode();
        int anotherHashCode = anotherCourseLevelMission.hashCode();
        assertThat(courseLevelMissionHashCode == anotherHashCode).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAnotherCourseLevelMission() {
        return Stream.of(
                Arguments.of(Arrays.asList("백엔드", "레벨1", "자동차경주"), true),
                Arguments.of(Arrays.asList("백엔드", "레벨1", "숫자야구게임"), false)
        );
    }
}