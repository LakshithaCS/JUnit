package assertions;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String[] getStudentNames(String department) {
        return students.stream()
                .filter(student -> department.equals(student.getDepartment()))
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public List<String> getStudentNamesAsList(String department) {
        return students.stream()
                .filter(student -> department.equals(student.getDepartment()))
                .map(Student::getName)
                .toList();
    }

}
