import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
    private GradeBook gradeBook1;
    private GradeBook gradeBook2;

    @BeforeEach
    void setUp() throws Exception {
        gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);
        
        // Add scores to gradeBook1
        gradeBook1.addScore(10.0);
        gradeBook1.addScore(15.0);
        gradeBook1.addScore(20.0); // Total of 3 scores added

        // Add scores to gradeBook2
        gradeBook2.addScore(5.0);
        gradeBook2.addScore(25.0); // Total of 2 scores added
    }

    @AfterEach
    void tearDown() throws Exception {
        gradeBook1 = null;
        gradeBook2 = null;
    }

    @Test
    void testAddScore() {
        // Test for gradeBook1
        assertEquals(3, gradeBook1.getScoreSize());
        assertEquals("10.0 15.0 20.0 ", gradeBook1.toString()); // Make sure the space is at the end
        
        // Test for gradeBook2
        assertEquals(2, gradeBook2.getScoreSize());
        assertEquals("5.0 25.0 ", gradeBook2.toString()); // Make sure the space is at the end
    }

    @Test
    void testSum() {
        assertEquals(45.0, gradeBook1.sum());
        assertEquals(30.0, gradeBook2.sum());
    }

    @Test
    void testMinimum() {
        assertEquals(10.0, gradeBook1.minimum());
        assertEquals(5.0, gradeBook2.minimum());
    }

    @Test
    void testFinalScore() {
        assertEquals(35.0, gradeBook1.finalScore()); // 45.0 - 10.0
        assertEquals(25.0, gradeBook2.finalScore()); // 30.0 - 5.0
    }
}