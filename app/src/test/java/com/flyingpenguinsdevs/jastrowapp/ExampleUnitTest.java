package com.flyingpenguinsdevs.jastrowapp;

import com.example.moish.jastrowapp.IntToString;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        assertTrue(IntToString.toStringOfLengthX(104, 5).length() == 5);
    }
}