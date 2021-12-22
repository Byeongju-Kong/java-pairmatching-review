package pairmatching.model.crew;

import java.util.List;

public class CrewPair {
    private final List<String> crewNames;

    public static CrewPair of(final List<String> crewNames) {
        return new CrewPair(crewNames);
    }

    private CrewPair(final List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public boolean isSameCrewPairWith(final CrewPair another) {
        return another.crewNames.stream()
                .filter(this::getSameNameCount)
                .count() == 2;
    }

    private boolean getSameNameCount(final String anotherCrewPairName) {
        return crewNames.stream()
                .anyMatch(name -> name.equals(anotherCrewPairName));
    }
}
