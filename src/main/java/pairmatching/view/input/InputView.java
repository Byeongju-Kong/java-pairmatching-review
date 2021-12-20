package pairmatching.view.input;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public interface InputView {
    String NEW_LINE = "\n";

    default String getUserInputWithNewLine() {
        String userInput = readLine();
        System.out.println(NEW_LINE);
        return userInput;
    }

    String inputFunction();

    void showErrorMessage(final String errorMessage);

    List<String> inputCourseLevelMission();
}
