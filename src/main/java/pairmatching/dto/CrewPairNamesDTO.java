package pairmatching.dto;

import java.util.List;

public class CrewPairNamesDTO {
    private final List<String> crewNames;

    public CrewPairNamesDTO(final List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public List<String> getCrewNames() {
        return crewNames;
    }
}
