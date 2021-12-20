package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.view.input.namereader.CrewNameReader;

import java.util.List;

public class MatchingFunction extends FunctionStrategy {
    public MatchingFunction(UserInputController userInputController, final CrewNameReader crewNameReader) {
        super(userInputController, crewNameReader);
    }

    @Override
    public void run() {
        CourseLevelMission courseLevelMission = userInputController.getUserInputCourseAndLevelAndMission();
    }
}
