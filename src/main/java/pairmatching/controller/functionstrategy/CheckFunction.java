package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.view.input.namereader.CrewNameReader;

public class CheckFunction extends FunctionStrategy {
    public CheckFunction(UserInputController userInputController, final CrewNameReader crewNameReader) {
        super(userInputController, crewNameReader);
    }

    @Override
    public void run() {
        CourseLevelMission courseLevelMission = userInputController.getUserInputCourseAndLevelAndMission();
    }
}
