package pairmatching.model.crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.dto.CrewPairNamesDTO;
import pairmatching.model.courselevelmission.vo.Level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL1;
import static pairmatching.model.courselevelmission.vo.Level.LEVEL2;

class CrewPairsTest {
    private final List<String> crewNames = Arrays.asList("Chris", "Henry", "Brandon", "Kane");
    private final CrewPairs crewPairs = CrewPairs.from(crewNames, LEVEL1);

    @ParameterizedTest
    @DisplayName("같은 레벨에서 매칭됐던 조합이 하나라도 있는지 반환한다.")
    @MethodSource("provideOtherCrewNamesAndExpected")
    void hasSameCrewPair(final List<String> otherCrewNames, Level anotherLevel, final boolean expected) {
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
    
    @Test
    @DisplayName("짝 지어진 크루 이름들을 반환한다.")
    void getCrewPairsNames() {
        List<List<String>> actual = crewPairs.getCrewPairsNames()
                .stream()
                .map(CrewPairNamesDTO::getCrewNames)
                .collect(Collectors.toList());
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Chris", "Henry"), Arrays.asList("Brandon", "Kane"));
        assertThat(actual).isEqualTo(expected);
    }
}