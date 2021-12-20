package pairmatching.view.input;

public class ConsoleInputView implements InputView {
    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String FUNCTION_LIST = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료\n";

    public void showErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

    public String inputFunction() {
        System.out.println(FUNCTION_LIST);
        return getUserInputWithNewLine();
    }
}
