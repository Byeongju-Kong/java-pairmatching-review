package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.MatchingLogs;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.view.input.namereader.CrewNameReader;

public abstract class FunctionStrategy {
    protected final UserInputController userInputController;
    protected final CrewNameReader crewNameReader;
    protected MatchingLogs matchingLogs = new MatchingLogs();

    protected FunctionStrategy(final UserInputController userInputController, final CrewNameReader crewNameReader) {
        this.userInputController = userInputController;
        this.crewNameReader = crewNameReader;
    }

    public abstract void run();
}
