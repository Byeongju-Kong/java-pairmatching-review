package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.matchinglog.MatchingLogs;
import pairmatching.view.input.namereader.CrewNameReader;

import java.io.IOException;

public abstract class FunctionStrategy {
    protected final UserInputController userInputController;
    protected final CrewNameReader crewNameReader;
    protected MatchingLogs matchingLogs = new MatchingLogs();

    protected FunctionStrategy(final UserInputController userInputController, final CrewNameReader crewNameReader) {
        this.userInputController = userInputController;
        this.crewNameReader = crewNameReader;
    }

    public abstract void run() throws IOException;
}
