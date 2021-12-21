package pairmatching.controller.functionstrategy;

import pairmatching.controller.UserInputController;
import pairmatching.model.courselevelmission.CourseLevelMission;
import pairmatching.model.courselevelmission.vo.Course;
import pairmatching.view.input.namereader.CrewNameReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingFunction extends FunctionStrategy {
    private static final String BACK_END_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONT_END_FILE_PATH = "src/main/resources/frontend-crew.md";

    public MatchingFunction(UserInputController userInputController, final CrewNameReader crewNameReader) {
        super(userInputController, crewNameReader);
    }

    @Override
    public void run() throws IOException {
        CourseLevelMission courseLevelMission = userInputController.getUserInputCourseAndLevelAndMission();
        Course inputCourse = courseLevelMission.getCourse();
        List<String> crewNames = readCrewNames(inputCourse);
    }

    private List<String> readCrewNames(final Course course) throws IOException {
        if (course == Course.BACK_END) {
            return crewNameReader.read(BACK_END_FILE_PATH);
        }
        return crewNameReader.read(FRONT_END_FILE_PATH);
    }
}
