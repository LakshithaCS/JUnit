package assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}