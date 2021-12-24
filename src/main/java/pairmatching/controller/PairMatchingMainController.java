package pairmatching.controller;

import pairmatching.controller.functionstrategy.CheckFunction;
import pairmatching.controller.functionstrategy.FunctionStrategy;
import pairmatching.controller.functionstrategy.MatchingFunction;
import pairmatching.controller.functionstrategy.ResetFunction;
import pairmatching.model.Function;
import pairmatching.view.input.InputView;
import pairmatching.view.input.namereader.CrewNameReader;
import pairmatching.view.output.OutputView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PairMatchingMainController {
    private final CrewNameReader crewNameReader;
    private final UserInputController userInputController;
    private final OutputView outputView;
    private final Map<Function, FunctionStrategy> functionStrategies = new HashMap<>();

    public PairMatchingMainController(final InputView inputView, final OutputView outputView,
                                      final CrewNameReader crewNameReader) {
        this.crewNameReader = crewNameReader;
        userInputController = new UserInputController(inputView);
        this.outputView = outputView;
        initializeFunctionStrategy();
    }

    private void initializeFunctionStrategy() {
        functionStrategies.put(Function.MATCH, new MatchingFunction(userInputController, outputView, crewNameReader));
        functionStrategies.put(Function.CHECK, new CheckFunction(userInputController, outputView, crewNameReader));
        functionStrategies.put(Function.RESET, new ResetFunction(userInputController, outputView, crewNameReader));
    }

    public void run() throws IOException {
        Function userInputFunction = userInputController.getUserInputFunction();
        while (userInputFunction != Function.QUIT) {
            FunctionStrategy functionStrategy = functionStrategies.get(userInputFunction);
            functionStrategy.run();
            userInputFunction = userInputController.getUserInputFunction();
        }
    }
}
