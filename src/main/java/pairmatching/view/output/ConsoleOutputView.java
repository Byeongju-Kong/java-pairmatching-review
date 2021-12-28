package pairmatching.view.output;

import pairmatching.dto.CrewPairNamesDTO;

import java.util.List;
import java.util.StringJoiner;

public class ConsoleOutputView implements OutputView {
    private static final String MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String NAME_DELIMITER = " : ";

    public void showCrewPairs(final List<CrewPairNamesDTO> crewPairNames) {
        System.out.println(MATCHING_RESULT_MESSAGE);
        crewPairNames.forEach(this::showCrewPair);
    }

    private void showCrewPair(final CrewPairNamesDTO crewPairNamesDTO) {
        StringJoiner result = new StringJoiner(NAME_DELIMITER);
        List<String> crewPairNames = crewPairNamesDTO.getCrewNames();
        crewPairNames.forEach(result::add);
        System.out.println(result);
    }
}
