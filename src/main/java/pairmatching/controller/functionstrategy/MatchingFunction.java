package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.courselevelmission.vo.Course;
import pairmatching.model.courselevelmission.vo.Level;
import pairmatching.model.crew.CrewPairs;
import pairmatching.view.input.namereader.CrewNameReader;
import pairmatching.view.input.vo.OverWrite;
import pairmatching.view.output.OutputView;

import java.io.IOException;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingFunction extends FunctionStrategy {
    private static final String BACK_END_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONT_END_FILE_PATH = "src/main/resources/frontend-crew.md";
    private static final int MAX_TRIAL_COUNT = 3;

    public MatchingFunction(UserInputController userInputController, final OutputView outputView,
                            final CrewNameReader crewNameReader) {
        super(userInputController, outputView, crewNameReader);
    }

    @Override
    public void run() throws IOException {
        CourseLevelMission courseLevelMission = userInputController.getUserInputCourseAndLevelAndMission();
        List<String> crewNames = readCrewNames(courseLevelMission.getCourse());
        if (canMatchNew(courseLevelMission)) {
            match(crewNames, courseLevelMission);
            outputView.showCrewPairs(matchingLogs.getCrewPairsNames(courseLevelMission));
        }
    }

    private boolean canMatchNew(final CourseLevelMission courseLevelMission) {
        if (matchingLogs.hasAlreadyMatched(courseLevelMission)) {
            return userInputController.getUserInputOverWrite() == OverWrite.YES;
        }
        return true;
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
