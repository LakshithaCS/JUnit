package assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceTest {

    @Test
    void testGetStudents() {
        StudentService studentService = new StudentService();
        boolean actual = studentService.getStudents().isEmpty();

        assertTrue(actual);
        assertTrue(() -> actual); // boolean supplier
        assertTrue(actual, "Student list is not empty"); // with error message
        assertTrue(() -> actual, "Student list is not empty"); // boolean supplier + with error message
        assertTrue(actual, () -> "Student list is not empty"); // String supplier for error message
        assertTrue(() -> actual, () -> "Student list is not empty"); // boolean supplier + String supplier for error message
    }

    @Test
    void testGetStudents_assert_false() {
        StudentService studentService = new StudentService();
        boolean actual = !studentService.getStudents().isEmpty();

        assertFalse(actual);
        assertFalse(() -> actual); // boolean supplier
        assertFalse(actual, "Student list is not empty"); // with error message
        assertFalse(() -> actual, "Student list is not empty"); // boolean supplier + with error message
        assertFalse(actual, () -> "Student list is not empty"); // String supplier for error message
        assertFalse(() -> actual, () -> "Student list is not empty"); // boolean supplier + String supplier for error message
    }

    @Test
    void testGetStudents_assert_null() {
        StudentService studentService = new StudentService();
        Student actual = studentService.getStudentById(1);

        assertNull(actual);
        assertNull(actual, "Student is not null"); // with error message
        assertNull(actual, () -> "Student is not null"); // String supplier for error message
    }

    @Test
    void testGetStudents_assert_not_null() {
        StudentService studentService = new StudentService();
        studentService.addStudent(new Student(1, "Alice"));
        Student actual = studentService.getStudentById(1);

        assertNotNull(actual);
        assertNotNull(actual, "Student is not found"); // with error message
        assertNotNull(actual, () -> "Student is not found"); // String supplier for error message
    }

    @Test
    void testGetStudents_assert_equals() {
        StudentService studentService = new StudentService();
        Student expected = new Student(1, "Alice");
        studentService.addStudent(expected);
        Student actual = studentService.getStudentById(1);

        assertEquals(1, actual.getId());
        assertEquals("Alice", actual.getName());
        assertEquals(expected, actual);

        assertEquals("Alice", actual.getName(), "Student is not found"); // with error message
        assertEquals(expected, actual, () -> "Student is not found"); // String supplier for error message
    }

    @Test
    void testGetStudents_assert_not_equals() {
        StudentService studentService = new StudentService();
        Student alice = new Student(1, "Alice");
        Student john = new Student(2, "John");
        studentService.addStudent(john);
        Student actual = studentService.getStudentById(2);

        assertNotEquals(1, actual.getId());
        assertNotEquals("Alice", actual.getName());
        assertNotEquals(alice, actual);

        assertNotEquals("Alice", actual.getName(), "Student is not found"); // with error message
        assertNotEquals(alice, actual, () -> "Student is not found"); // String supplier for error message
    }

    @Test
    void testGetStudents_assert_array_equals() {
        StudentService studentService = new StudentService();
        Student alice = new Student(1, "Alice", "CS");
        Student john = new Student(2, "John", "CS");
        Student bob = new Student(3, "Bob", "EE");
        studentService.addStudent(alice);
        studentService.addStudent(john);
        studentService.addStudent(bob);
        String[] expected = {"Alice", "John"};
        String[] actual = studentService.getStudentNames("CS");

        assertArrayEquals(expected, actual);
        assertArrayEquals(expected, actual, "Student names are not equal"); // with error message
        assertArrayEquals(expected, actual, () -> "Student names are not equal"); // String supplier for error message
    }
}