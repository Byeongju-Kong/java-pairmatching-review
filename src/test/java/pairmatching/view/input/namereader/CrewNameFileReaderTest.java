package pairmatching.view.input.namereader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CrewNameFileReaderTest {
    @ParameterizedTest
    @DisplayName("파일에 담긴 이름들을 읽어 List<String>으로 반환한다.")
    @MethodSource("provideFilePathAndExpectedNames")
    void readNames(final String filePath, final List<String> expectedNames) throws IOException {
        CrewNameReader crewNameReader = new CrewNameFileReader();
        List<String> actualNames = crewNameReader.read(filePath);
        assertThat(actualNames).isEqualTo(expectedNames);
    }

    private static Stream<Arguments> provideFilePathAndExpectedNames() {
        List<String> backEndNames =
                Arrays.asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협",
                        "덕규", "태산", "경태", "수겸", "현준", "준섭", "한나",
                        "소연", "호열", "대남", "용팔", "구식", "달재");
        List<String> frontEndNames =
                Arrays.asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브",
                        "제시", "라라", "린다", "리사", "니콜", "로드", "윌터", "제키");
        String backEndCrewNameFilePath = "src/main/resources/backend-crew.md";
        String frondEndCrewNameFilePath = "src/main/resources/frontend-crew.md";
        return Stream.of(
                Arguments.of(backEndCrewNameFilePath, backEndNames),
                Arguments.of(frondEndCrewNameFilePath, frontEndNames)
        );
    }
}
