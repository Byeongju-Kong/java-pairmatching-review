package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.matchinglog.MatchingLogs;
import pairmatching.view.input.namereader.CrewNameReader;
import pairmatching.view.output.OutputView;

public class ResetFunction extends FunctionStrategy{
    public ResetFunction(UserInputController userInputController, final OutputView outputView,
                         final CrewNameReader crewNameReader) {
        super(userInputController, outputView, crewNameReader);
    }

    @Override
    public void run() {
        matchingLogs = new MatchingLogs();
    }
}
