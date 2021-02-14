package pl.coderslab.spring01hibernatekrajeew06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SimpleSampleTest {
    @Test
    public void firstTest(){
        assertEquals(3, 5-2);
    }

    @Test
    public void secondTest(){
        assertEquals("ala", String.join("", Arrays.asList("a", "l", "a")));
    }
}
