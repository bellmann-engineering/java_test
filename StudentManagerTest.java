import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentManagerTest {
    private StudentManager studentManager;

    @BeforeEach
    public void setup() {
        studentManager = new StudentManager();
    }

    @Test
    public void testAddStudent() {
        // Arrange
        String name = "John Doe";
        int age = 20;

        // Act
        studentManager.addStudent(name, age);

        // Assert
        List<String> courses = studentManager.getCoursesForStudent(name);
        Assertions.assertEquals(0, courses.size());
    }

    @Test
    public void testEnrollStudentInCourse() {
        // Arrange
        String name = "Jane Smith";
        int age = 22;
        String course = "Mathematics";
        studentManager.addStudent(name, age);

        // Act
        studentManager.enrollStudentInCourse(name, course);

        // Assert
        List<String> courses = studentManager.getCoursesForStudent(name);
        Assertions.assertEquals(1, courses.size());
        Assertions.assertTrue(courses.contains(course));
    }

    @Test
    public void testRemoveStudent() {
        // Arrange
        String name = "Alice Johnson";
        int age = 19;
        studentManager.addStudent(name, age);

        // Act
        studentManager.removeStudent(name);

        // Assert
        List<String> courses = studentManager.getCoursesForStudent(name);
        Assertions.assertEquals(0, courses.size());
    }
}
