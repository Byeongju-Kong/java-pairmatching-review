package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.courselevelmission.vo.Course;
import pairmatching.model.courselevelmission.vo.Level;
import pairmatching.model.crew.CrewPairs;
import pairmatching.view.input.namereader.CrewNameReader;

import java.io.IOException;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingFunction extends FunctionStrategy {
    private static final String BACK_END_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONT_END_FILE_PATH = "src/main/resources/frontend-crew.md";
    private static final int MAX_TRIAL_COUNT = 3;

    public MatchingFunction(UserInputController userInputController, final CrewNameReader crewNameReader) {
        super(userInputController, crewNameReader);
    }

    @Override
    public void run() throws IOException {
        CourseLevelMission courseLevelMission = userInputController.getUserInputCourseAndLevelAndMission();
        Course inputCourse = courseLevelMission.getCourse();
        List<String> crewNames = readCrewNames(inputCourse);
        match(crewNames, courseLevelMission);
    }

    private List<String> readCrewNames(final Course course) throws IOException {
        if (course == Course.BACK_END) {
            return crewNameReader.read(BACK_END_FILE_PATH);
        }
        return crewNameReader.read(FRONT_END_FILE_PATH);
    }

    private void match(final List<String> crewNames, final CourseLevelMission courseLevelMission) {
        int trialCount = 0;
        CrewPairs newCrewPairs;
        Level userInputLevel = courseLevelMission.getLevel();
        do {
            List<String> shuffledCrewNames = shuffle(crewNames);
            newCrewPairs = CrewPairs.from(shuffledCrewNames, userInputLevel);
            checkTrialCount(++trialCount);
        } while (!matchingLogs.hasSameCrewPair(newCrewPairs));
        matchingLogs.addLog(courseLevelMission, newCrewPairs);
    }

    private void checkTrialCount(final int trialCount) {
        if (trialCount == MAX_TRIAL_COUNT) {
            throw new IllegalStateException("매칭을 3번 시도했지만 실패했습니다.");
        }
    }
}
