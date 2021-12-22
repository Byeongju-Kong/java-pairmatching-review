package pairmatching.model.matchinglog;

import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.crew.CrewPairs;

import java.util.HashMap;
import java.util.Map;

public class MatchingLogs {
    private final Map<CourseLevelMission, CrewPairs> logs = new HashMap<>();

    public boolean hasAlreadyMatched(final CourseLevelMission newCourseLevelMission) {
        return logs.keySet().stream()
                .anyMatch(courseLevelMissionLog -> courseLevelMissionLog.equals(newCourseLevelMission));
    }

    public void addLog(final CourseLevelMission courseLevelMission, final CrewPairs newCrewPairs) {
        logs.put(courseLevelMission, newCrewPairs);
    }

    public boolean hasSameCrewPair(final CrewPairs newCrewPairs) {
        return logs.values().stream()
                .anyMatch(crewPairsLog -> crewPairsLog.hasSameCrewPair(newCrewPairs));
    }
}
