package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.view.input.namereader.CrewNameReader;
import pairmatching.view.output.OutputView;

public class CheckFunction extends FunctionStrategy {
    public CheckFunction(UserInputController userInputController, final OutputView outputView,
                         final CrewNameReader crewNameReader) {
        super(userInputController, outputView, crewNameReader);
    }

    @Override
    public void run() {
        CourseLevelMission courseLevelMission = userInputController.getUserInputCourseAndLevelAndMission();
        outputView.showCrewPairs(matchingLogs.getCrewPairsNames(courseLevelMission));
    }
}
