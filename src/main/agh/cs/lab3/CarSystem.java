package agh.cs.lab3;


import agh.cs.lab2.*;

public class CarSystem {

    public static void main(String[] args) {
        Car myCar = new Car();
        MoveDirection[] directions = OptionParser.parse(args);
        for(MoveDirection direction: directions){
            myCar.move(direction);
        }
        System.out.println(myCar);
    }

}
