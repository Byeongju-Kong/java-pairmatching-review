package pairmatching.model.matchinglog;

import pairmatching.dto.CrewPairNamesDTO;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.crew.CrewPairs;

import java.util.HashMap;
import java.util.List;
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

    public List<CrewPairNamesDTO> getCrewPairsNames(final CourseLevelMission userInputCourseLevelMission) {
        CrewPairs userWanted = logs.keySet().stream()
                .filter(courseLevelMission -> courseLevelMission.equals(userInputCourseLevelMission))
                .findAny()
                .map(logs::get)
                .orElseThrow(() -> new IllegalStateException("입력 하신 과정, 레벨, 미션에 해당하는 매칭 정보가 없습니다."));
        return userWanted.getCrewPairsNames();
    }
}
