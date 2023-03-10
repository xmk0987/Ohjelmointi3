package fi.tuni.prog3.junitattainment;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class AttainmentTest {
    private final Attainment attainment = new Attainment("123", "12345", 5);


    @Test
    void compareTo() {
        Attainment testAtt1 = new Attainment("bbb", "bbb", 1);
        Attainment testAtt2 = new Attainment("aaa", "bbb", 1);
        Attainment testAtt3 = new Attainment("aaa", "aaa", 1);
        Attainment testAtt4 = new Attainment("bbb", "ccc", 1);


        Assertions.assertEquals(-1, testAtt1.compareTo(testAtt4));
        Assertions.assertEquals(1, testAtt1.compareTo(testAtt3));
        Assertions.assertEquals(0, testAtt3.compareTo(testAtt3));
        Assertions.assertEquals(1, testAtt1.compareTo(testAtt2));


    }

    @Test
    void testGetCourseCode() {
        String expResult = "123";
        String result = attainment.getCourseCode();
        Assertions.assertEquals(expResult, result);
        assertThrows(IllegalArgumentException.class, () ->
                new Attainment(null, "12345", 4));
    }

    @Test
    void testGetStudentNumber() {
        String expResult = "12345";
        String result = attainment.getStudentNumber();
        Assertions.assertEquals(expResult, result);
        assertThrows(IllegalArgumentException.class, () ->
                new Attainment("123", null, 4));
    }

    @Test
    void testGetGrade() {
        int expResult = 5;
        int result = attainment.getGrade();
        Assertions.assertEquals(expResult, result);
        assertThrows(IllegalArgumentException.class, () ->
                new Attainment("123", "12345", -2));
    }

    @Test
    void testToString() {
        String expected = "123 12345 5";
        Assertions.assertEquals(expected, attainment.toString());
    }
}