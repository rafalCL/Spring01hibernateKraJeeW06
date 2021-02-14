package pl.coderslab.spring01hibernatekrajeew06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnotherTest {
    @Test
    public void isItTrue(){
        assertTrue(42 > 12);
    }

    @Before
    public void before(){
        System.out.println("Test will start now");
    }

    @After
    public void after(){
        System.out.println("Just after test");
    }
}
