package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.matchinglog.MatchingLogs;
import pairmatching.view.input.namereader.CrewNameReader;
import pairmatching.view.output.OutputView;

import java.io.IOException;

public abstract class FunctionStrategy {
    protected final UserInputController userInputController;
    protected final OutputView outputView;
    protected final CrewNameReader crewNameReader;
    protected MatchingLogs matchingLogs = new MatchingLogs();

    protected FunctionStrategy(final UserInputController userInputController, final OutputView outputView,
                               final CrewNameReader crewNameReader) {
        this.userInputController = userInputController;
        this.outputView = outputView;
        this.crewNameReader = crewNameReader;
    }

    public abstract void run() throws IOException;
}
