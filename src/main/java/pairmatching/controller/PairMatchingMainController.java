package pairmatching.controller;

import pairmatching.controller.functionstrategy.CheckFunction;
import pairmatching.controller.functionstrategy.FunctionStrategy;
import pairmatching.controller.functionstrategy.MatchingFunction;
import pairmatching.controller.functionstrategy.ResetFunction;
import pairmatching.model.Function;
import pairmatching.view.input.InputView;
import pairmatching.view.input.namereader.CrewNameReader;

import java.util.HashMap;
import java.util.Map;

public class PairMatchingMainController {
    private final CrewNameReader crewNameReader;
    private final UserInputController userInputController;
    private final Map<Function, FunctionStrategy> functionStrategies = new HashMap<>();


    public PairMatchingMainController(final CrewNameReader crewNameReader, final InputView inputView) {
        this.crewNameReader = crewNameReader;
        userInputController = new UserInputController(inputView);
        initializeFunctionStrategy();
    }

    private void initializeFunctionStrategy() {
        functionStrategies.put(Function.MATCH, new MatchingFunction(userInputController, crewNameReader));
        functionStrategies.put(Function.CHECK, new CheckFunction(userInputController, crewNameReader));
        functionStrategies.put(Function.RESET, new ResetFunction(userInputController, crewNameReader));
    }

    public void run() {
        Function userInputFunction;
        do {
             userInputFunction = userInputController.getUserInputFunction();
             FunctionStrategy functionStrategy = functionStrategies.get(userInputFunction);
             functionStrategy.run();
        } while(userInputFunction != Function.QUIT);
    }
}
