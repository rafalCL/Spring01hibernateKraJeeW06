package pl.coderslab.spring01hibernatekrajeew06.ut;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstTest {

    @Test
    public void shouldConcatTwoStrings() {
        // given
        First first = new First();
        // when
        String actual = first.concatString("ala", "makota");
        // then
        assertEquals("alamakota", actual);
    }

    @Test
    public void shouldConcatStringWithNull() {
        // given
        First first = new First();
        // when
        String actual = first.concatString("napis", null);
        // then
        assertEquals("napisnull", actual);
    }

    @Test
    public void shouldConcatNullWithString() {
        First first = new First();

        String actual = first.concatString(null, "some String");

        assertEquals("nullsome String", actual);
    }

    @Test
    public void shouldConcatNulls() {
        First first = new First();

        String actual = first.concatString(null, null);

        assertEquals("nullnull", actual);
    }

    @Test
    public void shouldMultiplyTwoPositiveNumbers() {
        First first = new First();

        int actual = first.multiply(2, 3);

        assertEquals(6, actual);
    }

    @Test
    public void shouldMultiplyTwoNegativeNumbers() {
        First first = new First();

        int actual = first.multiply(-12, -2);

        assertEquals(24, actual);
    }

    @Test
    public void shouldMultiplyByZero() {
        First first = new First();

        int actual = first.multiply(123, 0);

        assertEquals(0, actual);
    }
}