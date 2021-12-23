package pairmatching.model.crew;

import pairmatching.dto.CrewPairNamesDTO;
import pairmatching.model.courselevelmission.vo.Level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CrewPairs {
    private final List<CrewPair> values;
    private final Level level;

    public static CrewPairs from(final List<String> crewNames, final Level level) {
        return new CrewPairs(crewNames, level);
    }

    private CrewPairs(final List<String> crewNames, final Level level) {
        values = match(new LinkedList<>(crewNames));
        this.level = level;
    }

    private List<CrewPair> match(final Queue<String> crewNames) {
        List<CrewPair> crewPairs = new ArrayList<>();
        while (!crewNames.isEmpty()) {
            crewPairs.add(pairUp(crewNames));
        }
        return crewPairs;
    }

    private CrewPair pairUp(final Queue<String> crewNames) {
        if (crewNames.size() == 3) {
            return CrewPair.of(Arrays.asList(crewNames.poll(), crewNames.poll(), crewNames.poll()));
        }
        return CrewPair.of(Arrays.asList(crewNames.poll(), crewNames.poll()));
    }

    public boolean hasSameCrewPair(final CrewPairs otherCrewPairs) {
        if (level != otherCrewPairs.level) {
            return false;
        }
        return otherCrewPairs.values.stream()
                .anyMatch(this::hasSameCrewPair);
    }

    private boolean hasSameCrewPair(final CrewPair anotherCrewPair) {
        return values.stream()
                .anyMatch(crewPair -> crewPair.isSameCrewPairWith(anotherCrewPair));
    }

    public List<CrewPairNamesDTO> getCrewPairsNames() {
        return values.stream()
                .map(CrewPair::getNames)
                .collect(Collectors.toList());
    }
}
