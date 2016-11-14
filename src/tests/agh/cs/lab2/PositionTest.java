package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testtoString() throws Exception {
        assertEquals("(1,2)", new Position(1,2).toString());
    }

    @Test
    public void testSmaller() throws Exception {
        assertTrue(new Position(1,2).smaller(new Position(1,2)));
        assertTrue(new Position(1,2).smaller(new Position(2,3)));
        assertFalse(new Position(1,2).smaller(new Position(0,1)));
        assertFalse(new Position(1,2).smaller(new Position(2,1)));
    }

    @Test
    public void testGreater() throws Exception {
        assertTrue(new Position(1,2).smaller(new Position(1,2)));
        assertTrue(new Position(1,2).smaller(new Position(2,3)));
        assertFalse(new Position(1,2).smaller(new Position(0,1)));
        assertFalse(new Position(1,2).smaller(new Position(2,1)));
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(new Position(3,4), new Position(1,2).add(new Position(2,2)));
    }

}