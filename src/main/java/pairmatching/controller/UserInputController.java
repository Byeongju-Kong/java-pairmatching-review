package pairmatching.controller;

import pairmatching.model.Function;
import pairmatching.view.input.InputView;

public class UserInputController {
    private final InputView inputView;
    private boolean isWrongInput;

    public UserInputController(final InputView inputView) {
        this.inputView = inputView;
        this.isWrongInput = true;
    }

    public Function inputUserInputFunction() {
        isWrongInput = true;
        Function userInputFunction = null;
        while (isWrongInput) {
            userInputFunction = inputFunction();
        }
        return userInputFunction;
    }

    private Function inputFunction() {
        String userInputFunctionValue = inputView.inputFunction();
        Function userInputFunction = null;
        try {
            userInputFunction = Function.of(userInputFunctionValue);
            isWrongInput = false;
        } catch (Exception exception) {
            inputView.showErrorMessage(exception.getMessage());
        }
        return userInputFunction;
    }
}
