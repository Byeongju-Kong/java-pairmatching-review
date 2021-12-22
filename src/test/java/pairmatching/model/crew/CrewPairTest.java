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

class CrewPairTest {
    @ParameterizedTest
    @DisplayName("동일한 레벨에서 매칭되었던 적이 있는지 반환한다.")
    @MethodSource("provideOtherCrewNamesAndLevelAndExpected")
    void isSameWith(final List<String> otherCrewNames, final boolean expected) {
        CrewPair crewPair = CrewPair.of(Arrays.asList("Chris", "Henry", "Brandon"));
        CrewPair another = CrewPair.of(otherCrewNames);
        boolean actual = crewPair.isSameCrewPairWith(another);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOtherCrewNamesAndLevelAndExpected() {
        return Stream.of(
                Arguments.of(Arrays.asList("Chris", "Henry"), true),
                Arguments.of(Arrays.asList("Chris", "Henry"), false),
                Arguments.of(Arrays.asList("Chris", "Kane"), false)
        );
    }
}