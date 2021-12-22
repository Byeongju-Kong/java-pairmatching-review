package pairmatching.model.crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.model.courselevelmission.vo.Level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL1;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL2;

class CrewPairsTest {
    @ParameterizedTest
    @DisplayName("같은 레벨에서 매칭됐던 조합이 하나라도 있는지 반환한다.")
    @MethodSource("provideOtherCrewNamesAndExpected")
    void hasSameCrewPair(final List<String> otherCrewNames, Level anotherLevel, final boolean expected) {
        List<String> crewNames = Arrays.asList("Chris", "Henry", "Brandon", "Kane");
        CrewPairs crewPairs = CrewPairs.from(crewNames, LEVEL1);
        CrewPairs otherCrewPairs = CrewPairs.from(otherCrewNames, anotherLevel);
        boolean actual = crewPairs.hasSameCrewPair(otherCrewPairs);
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