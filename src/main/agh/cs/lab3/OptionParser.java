package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class OptionParser {
    public static MoveDirection[] parse(String[] arguments){
        int i = 0;
        for(String argument : arguments){
            switch (argument){
                case "f":
                case "forward":
                case "b":
                case "backward":
                case "r":
                case "right":
                case "l":
                case "left":
                    i++;
            }
        }
        MoveDirection [] anser = new MoveDirection[i];
        i = 0;
        for(String argument : arguments){
            switch (argument){
                case "f":
                case "forward":
                    anser[i] = MoveDirection.Forward;
                    i++;
                    break;
                case "b":
                case "backward":
                    anser[i] = MoveDirection.Backward;
                    i++;
                    break;
                case "r":
                case "right":
                    anser[i] = MoveDirection.Right;
                    i++;
                    break;
                case "l":
                case "left":
                    anser[i] = MoveDirection.Left;
                    i++;
                    break;
            }
        }
        return anser;
    }
}
