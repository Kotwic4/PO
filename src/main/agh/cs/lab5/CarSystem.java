package agh.cs.lab5;


import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {
        MoveDirection[] directions = OptionParser.parse(args);
        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Position(-4,-4)));
        hayStacks.add(new HayStack(new Position(7,7)));
        hayStacks.add(new HayStack(new Position(3,6)));
        hayStacks.add(new HayStack(new Position(2,0)));
        IWorldMap map = new UnboundedMap(hayStacks);
        map.add(new agh.cs.lab4.Car(map));
        map.add(new agh.cs.lab4.Car(map,3,4));
        map.run(directions);
        System.out.println(map);
    }

}
