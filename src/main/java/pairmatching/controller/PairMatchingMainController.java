package pairmatching.controller;

import pairmatching.model.Function;
import pairmatching.view.input.InputView;
import pairmatching.view.input.namereader.CrewNameReader;

public class PairMatchingMainController {
    private final CrewNameReader crewNameReader;
    private final UserInputController userInputController;

    public PairMatchingMainController(final CrewNameReader crewNameReader, final InputView inputView) {
        this.crewNameReader = crewNameReader;
        userInputController = new UserInputController(inputView);
    }

    public void run() {
        Function userInputFunction = userInputController.inputUserInputFunction();
    }
}
