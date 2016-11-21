package agh.cs.lab4;

import agh.cs.lab2.*;
import agh.cs.lab3.OptionParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kotwic4 on 14.11.2016.
 */
public class RectangularMapTest {
    @Test
    public void canMoveToTest() throws Exception {
        RectangularMap map = new RectangularMap(10,5);
        assertFalse(map.canMoveTo(new Position(-1,-1)));
        assertFalse(map.canMoveTo(new Position(-1,1)));
        assertFalse(map.canMoveTo(new Position(1,-1)));
        assertFalse(map.canMoveTo(new Position(0,-1)));
        assertFalse(map.canMoveTo(new Position(-1,0)));
        assertFalse(map.canMoveTo(new Position(11,6)));
        assertFalse(map.canMoveTo(new Position(11,4)));
        assertFalse(map.canMoveTo(new Position(9,6)));
        assertTrue(map.canMoveTo(new Position(0,0)));
        assertTrue(map.canMoveTo(new Position(10,5)));
        assertTrue(map.canMoveTo(new Position(5,5)));
        map.add(new Car(map,5,5));
        assertFalse(map.canMoveTo(new Position(5,5)));
    }

    @Test
    public void addTest() throws Exception {
        RectangularMap map = new RectangularMap(10,5);
        Car car = new Car(map,5,5);
        assertTrue(map.add(car));
        assertFalse(map.add(car));
        assertFalse(map.add(new Car(map,5,5)));
        assertTrue(map.add(new Car(map,4,4)));
        assertFalse(map.add(new Car(map,4,4)));
    }

    @Test
    public void runTest() throws Exception {
        RectangularMap map = new RectangularMap(10, 5);
        map.add(new Car(map));
        map.add(new Car(map,3,4));
        MoveDirection[] directions = OptionParser.parse("f b r l f f r r f f f f f f f f".split(" "));
        map.run(directions);
        String string1 =
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | | |N| | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | | | | | | | | | | |\r\n" +
                        "  2: | | | | | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | |S| | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n";
        assertEquals(map.toString(),string1);
    }

    @Test
    public void isOccupiedTest() throws Exception {
        RectangularMap map = new RectangularMap(10,5);
        Car car = new Car(map,5,5);
        assertFalse(map.isOccupied(new Position(5,5)));
        assertFalse(map.isOccupied(new Position(4,4)));
        assertFalse(map.isOccupied(new Position(3,3)));
        map.add(car);
        map.add(new Car(map,4,4));
        assertTrue(map.isOccupied(new Position(5,5)));
        assertTrue(map.isOccupied(new Position(4,4)));
        assertFalse(map.isOccupied(new Position(3,3)));
    }

    @Test
    public void objectAtTest() throws Exception {
        RectangularMap map = new RectangularMap(10,5);
        Car car = new Car(map,5,5);
        assertEquals(map.objectAt(new Position(5,5)),null);
        assertEquals(map.objectAt(new Position(4,4)),null);
        assertEquals(map.objectAt(new Position(3,3)),null);
        map.add(car);
        map.add(new Car(map,4,4));
        assertEquals(map.objectAt(new Position(5,5)),car);
        assertNotEquals(map.objectAt(new Position(5,5)),null);
        assertNotEquals(map.objectAt(new Position(4,4)),null);
        assertEquals(map.objectAt(new Position(3,3)),null);
    }

    @Test
    public void toStringTest() throws Exception {
        RectangularMap map = new RectangularMap(10, 5);
        map.add(new Car(map));
        String string1 =
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                "  6: -----------------------\r\n" +
                "  5: | | | | | | | | | | | |\r\n" +
                "  4: | | | | | | | | | | | |\r\n" +
                "  3: | | | | | | | | | | | |\r\n" +
                "  2: | | |N| | | | | | | | |\r\n" +
                "  1: | | | | | | | | | | | |\r\n" +
                "  0: | | | | | | | | | | | |\r\n" +
                " -1: -----------------------\r\n";
        String string2 =
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | | | | | | | | | | |\r\n" +
                        "  4: | | | |N| | | | | | | |\r\n" +
                        "  3: | | | | | | | | | | | |\r\n" +
                        "  2: | | |N| | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | | | | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n";
        assertEquals(map.toString(),string1);
        map.add(new Car(map,3,4));
        assertEquals(map.toString(),string2);

    }

}