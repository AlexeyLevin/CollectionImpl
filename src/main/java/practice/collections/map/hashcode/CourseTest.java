package practice.collections.map.hashcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void testCourseHashCodeWithUuid101() throws Exception {
        final Course testCourse = new Course("101", "101", new ArrayList());
        final int code = '1' + '0' + '1';
        assertEquals("Course with the uuid 101 returns incorrect hashCode", code, testCourse.hashCode());
    }

    @Test
    public void testCourseHashCodeWithUuidNull() throws Exception {
        final Course testCourse = new Course(null, "101", new ArrayList());
        assertEquals("Course with the uuid null returns incorrect hashCode", 0, testCourse.hashCode());
    }

    @Test
    public void testCourseHashCodeWithEmptyUuid() throws Exception {
        final Course testCourse = new Course("", "101", new ArrayList());
        assertEquals("Course with the uuid null returns incorrect hashCode", 0, testCourse.hashCode());
    }

    @Test
    public void testSessionHashCode() throws Exception {
        final Date testDate = new Date();
        final Course testCourse = new Course("1l", "102", new ArrayList());
        final Course.Session session = testCourse.new Session(testDate);
        assertEquals(testDate.hashCode(), session.hashCode());
    }

}
