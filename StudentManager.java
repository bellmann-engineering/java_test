import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int age) {
        Student student = new Student(name, age);
        students.add(student);
    }

    public void enrollStudentInCourse(String studentName, String course) {
        Student student = findStudentByName(studentName);
        if (student != null) {
            student.enrollCourse(course);
        }
    }

    public void removeStudent(String name) {
        Student student = findStudentByName(name);
        if (student != null) {
            students.remove(student);
        }
    }

    public List<String> getCoursesForStudent(String name) {
        Student student = findStudentByName(name);
        return (student != null) ? student.getCourses() : new ArrayList<>();
    }

    private Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    // Inner Student class
    private static class Student {
        private String name;
        private int age;
        private List<String> courses;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
            this.courses = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<String> getCourses() {
            return courses;
        }

        public void enrollCourse(String course) {
            courses.add(course);
        }
    }
}
