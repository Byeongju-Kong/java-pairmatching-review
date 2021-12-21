package pairmatching.model.courselevelmission;

import pairmatching.model.courselevelmission.vo.Course;
import pairmatching.model.courselevelmission.vo.Level;
import pairmatching.model.courselevelmission.vo.Mission;

import java.util.List;

public class CourseLevelMission {
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final Course course;
    private final Level level;
    private final Mission mission;

    private CourseLevelMission(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static CourseLevelMission of(final List<String> userInput) {
        Course course = Course.of(userInput.get(COURSE_INDEX));
        Level level = Level.of(userInput.get(LEVEL_INDEX));
        Mission mission = Mission.of(userInput.get(MISSION_INDEX), level);
        return new CourseLevelMission(course, level, mission);
    }

    public Course getCourse() {
        return course;
    }
}
