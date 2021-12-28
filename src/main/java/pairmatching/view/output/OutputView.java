package pairmatching.view.output;

import pairmatching.dto.CrewPairNamesDTO;

import java.util.List;

public interface OutputView {
    void showCrewPairs(final List<CrewPairNamesDTO> crewPairNames);
}
