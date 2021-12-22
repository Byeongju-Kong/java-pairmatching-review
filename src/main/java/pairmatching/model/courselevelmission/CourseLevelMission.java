package pairmatching.model.courselevelmission;

import pairmatching.model.courselevelmission.vo.Course;
import pairmatching.model.courselevelmission.vo.Level;
import pairmatching.model.courselevelmission.vo.Mission;

import java.util.List;
import java.util.Objects;

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

    public Level getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseLevelMission that = (CourseLevelMission) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
