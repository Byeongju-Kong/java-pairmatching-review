package pairmatching;

import pairmatching.controller.PairMatchingMainController;
import pairmatching.view.input.ConsoleInputView;
import pairmatching.view.input.InputView;
import pairmatching.view.input.namereader.CrewNameFileReader;
import pairmatching.view.input.namereader.CrewNameReader;
import pairmatching.view.output.ConsoleOutputView;
import pairmatching.view.output.OutputView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        CrewNameReader crewNameReader = new CrewNameFileReader();
        PairMatchingMainController pairMatchingMainController =
                new PairMatchingMainController(inputView, outputView, crewNameReader);
        try {
            pairMatchingMainController.run();
        } catch (IOException ioException) {

        }
    }
}
