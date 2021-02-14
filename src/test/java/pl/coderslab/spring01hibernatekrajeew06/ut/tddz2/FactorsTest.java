package pl.coderslab.spring01hibernatekrajeew06.ut.tddz2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FactorsTest {

    @Test
    public void generatePrimeFactors() {
        // given
        int input = 16;
        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 16);

        // when
        List<Integer> actual = Factors.generatePrimeFactors(input);

        // then
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}