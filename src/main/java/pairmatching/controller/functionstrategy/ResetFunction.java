package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.MatchingLogs;
import pairmatching.view.input.namereader.CrewNameReader;

public class ResetFunction extends FunctionStrategy{
    public ResetFunction(UserInputController userInputController, final CrewNameReader crewNameReader) {
        super(userInputController, crewNameReader);
    }

    @Override
    public void run() {
        matchingLogs = new MatchingLogs();
    }
}
