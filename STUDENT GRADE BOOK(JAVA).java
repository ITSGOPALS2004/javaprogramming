import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    String name;
    List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public float getAverageGrade() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return ((float) total) / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", averageGrade=" + getAverageGrade() +
                '}';
    }
}

public class GradeBook {
    Map<String, Student> students;

    public GradeBook() {
        students = new HashMap<>();
    }

    public void addStudent(String name) {
        students.put(name, new Student(name));
    }

    public void addGrade(String name, int grade) {
        Student student = students.get(name);
        if (student != null) {
            student.addGrade(grade);
        }
    }

    public void printGradeBook() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.addStudent("John");
        gradeBook.addGrade("John", 85);
        gradeBook.addGrade("John", 90);
        gradeBook.addStudent("Jane");
        gradeBook.addGrade("Jane", 95);
        gradeBook.addGrade("Jane", 100);
        gradeBook.printGradeBook();
    }
}
