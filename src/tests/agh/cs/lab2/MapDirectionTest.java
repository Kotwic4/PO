package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("Północ", MapDirection.North.toString());
        assertEquals("Wschód", MapDirection.East.toString());
        assertEquals("Południe", MapDirection.South.toString());
        assertEquals("Zachód", MapDirection.West.toString());
    }

    @Test
    public void testNext() throws Exception {
        assertEquals(MapDirection.East, MapDirection.North.next());
        assertEquals(MapDirection.South, MapDirection.East.next());
        assertEquals(MapDirection.West, MapDirection.South.next());
        assertEquals(MapDirection.North, MapDirection.West.next());
    }

    @Test
    public void testPrevious() throws Exception {
        assertEquals(MapDirection.West, MapDirection.North.previous());
        assertEquals(MapDirection.North, MapDirection.East.previous());
        assertEquals(MapDirection.East, MapDirection.South.previous());
        assertEquals(MapDirection.South, MapDirection.West.previous());
    }

}