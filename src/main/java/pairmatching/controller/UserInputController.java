package pairmatching.controller;

import java.util.List;

import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.Function;
import pairmatching.view.input.InputView;

public class UserInputController {
    private final InputView inputView;
    private boolean isWrongInput;

    public UserInputController(final InputView inputView) {
        this.inputView = inputView;
        this.isWrongInput = true;
    }

    public Function getUserInputFunction() {
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


    public CourseLevelMission getUserInputCourseAndLevelAndMission() {
        isWrongInput = true;
        CourseLevelMission courseLevelMission = null;
        while (isWrongInput) {
            courseLevelMission = inputCourseAndLevelAndMission();
        }
        return courseLevelMission;
    }

    private CourseLevelMission inputCourseAndLevelAndMission() {
        CourseLevelMission courseLevelMission = null;
        try {
            List<String> userInputCourseLevelMission = inputView.inputCourseLevelMission();
            courseLevelMission = CourseLevelMission.of(userInputCourseLevelMission);
            isWrongInput = false;

        } catch (Exception exception) {
            inputView.showErrorMessage(exception.getMessage());
        }
        return courseLevelMission;
    }
}
