package pairmatching.model.courselevelmission.vo;

import java.util.Arrays;

public enum Course {
    BACK_END("백엔드"),
    FRONT_END("프론트엔드");

    private final String value;

    Course(final String value) {
        this.value = value;
    }

    public static Course of(final String userInputCourseValue) {
        return Arrays.stream(values())
                .filter(course -> userInputCourseValue.equals(course.value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("과정은 백엔드 혹은 프론트엔드 입니다."));
    }
}
