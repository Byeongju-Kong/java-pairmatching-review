package pairmatching.model.matchinglog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.courselevelmission.vo.Level;
import pairmatching.model.crew.CrewPairs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL1;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL2;

class MatchingLogsTest {
    private final MatchingLogs matchingLogs = new MatchingLogs();

    @BeforeEach
    void setUp() {
        List<String> userInputCourseLevelMission = Arrays.asList("백엔드", "레벨1", "자동차경주");
        CourseLevelMission courseLevelMission = CourseLevelMission.of(userInputCourseLevelMission);
        List<String> crewNames = Arrays.asList("Chris", "Henry", "Brandon", "Kane");
        CrewPairs crewPairs = CrewPairs.from(crewNames, LEVEL1);
        matchingLogs.addLog(courseLevelMission, crewPairs);
    }

    @ParameterizedTest
    @DisplayName("같은 레벨에서 매칭됐던 조합이 하나라도 있는지 반환한다.")
    @MethodSource("provideOtherCrewNamesAndExpected")
    void hasSameCrewPair(final List<String> otherCrewNames, final Level anotherLevel, final boolean expected) {
        CrewPairs newCrewPairs = CrewPairs.from(otherCrewNames, anotherLevel);
        boolean actual = matchingLogs.hasSameCrewPair(newCrewPairs);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOtherCrewNamesAndExpected() {
        return Stream.of(
                Arguments.of(Arrays.asList("Chris", "Henry", "Brandon", "Kane"), LEVEL1, true),
                Arguments.of(Arrays.asList("Chris", "Brandon", "Henry", "Kane"), LEVEL1, false),
                Arguments.of(Arrays.asList("Chris", "Henry", "Brandon", "Kane"), LEVEL2, false)
        );
    }
}