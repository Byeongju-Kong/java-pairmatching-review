package pairmatching.model.crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.dto.CrewPairNamesDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CrewPairTest {
    private final CrewPair crewPair = CrewPair.of(Arrays.asList("Chris", "Henry", "Brandon"));
    @ParameterizedTest
    @DisplayName("동일한 레벨에서 매칭되었던 적이 있는지 반환한다.")
    @MethodSource("provideOtherCrewNamesAndLevelAndExpected")
    void isSameWith(final List<String> otherCrewNames, final boolean expected) {
        CrewPair another = CrewPair.of(otherCrewNames);
        boolean actual = crewPair.isSameCrewPairWith(another);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOtherCrewNamesAndLevelAndExpected() {
        return Stream.of(
                Arguments.of(Arrays.asList("Chris", "Henry"), true),
                Arguments.of(Arrays.asList("Chris", "Kane"), false)
        );
    }

    @Test
    @DisplayName("짝 지어진 크루 이름들을 반환한다.")
    void getCrewNames() {
        CrewPairNamesDTO crewPairNamesDTO = crewPair.getNames();
        List<String> actual = crewPairNamesDTO.getCrewNames();
        List<String> expected = Arrays.asList("Chris", "Henry", "Brandon");
        assertThat(actual).isEqualTo(expected);
    }
}
