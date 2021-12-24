package pairmatching.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String FUNCTION_LIST = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료\n";

    private static final String COURSE_LEVEL_MISSION_INFO =
            "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n" +
            "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static final String DELIMITER_OF_COURSE_LEVEL_MISSION = ", ";
    private static final int ENOUGH_NUMBER_OF_COURSE_LEVEL_MISSION = 3;

    public void showErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

    public String inputFunction() {
        System.out.println(FUNCTION_LIST);
        return getUserInputWithNewLine();
    }

    public List<String> inputCourseLevelMission() {
        System.out.println(COURSE_LEVEL_MISSION_INFO);
        String userInput = getUserInputWithNewLine();
        List<String> courseLevelMission = Arrays.stream(userInput.split(DELIMITER_OF_COURSE_LEVEL_MISSION))
                .collect(Collectors.toList());
        validate(courseLevelMission);
        return courseLevelMission;
    }

    private void validate(final List<String> courseLevelMission) {
        if(courseLevelMission.size() != ENOUGH_NUMBER_OF_COURSE_LEVEL_MISSION) {
            throw new IllegalArgumentException("과정, 레벨, 미션 의 형태로 입력하셔야합니다.");
        }
    }
}
