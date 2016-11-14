package agh.cs.lab4;


import agh.cs.lab2.*;
import agh.cs.lab3.*;

public class CarSystem {

    public static void main(String[] args) {
        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.add(new Car(map));
        map.add(new Car(map,3,4));
        map.run(directions);
        System.out.println(map);
    }

}
