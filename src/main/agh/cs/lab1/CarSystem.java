package agh.cs.lab1;
import static java.lang.System.out;
public class CarSystem {
    public static void main(String[] args) {
        out.println("Start");
        run(convertStringToDirection(args));
        out.println("Stop");
    }
    private static void run(Direction[] arguments){
        for(Direction argument: arguments){
            switch (argument){
                case Forward:
                    out.println("Samochód jedzie do przodu");
                    break;
                case Backward:
                    out.println("Samochód jedzie do tyłu");
                    break;
                case Right:
                    out.println("Samochód jedzie w prawo");
                    break;
                case Left:
                    out.println("Samochód jedzie w lewo");
                    break;
                default:
                    break;
            }
        }
    }
    private static Direction[] convertStringToDirection(String[] arguments){
        Direction[] anser = new Direction[arguments.length];
        for(int i = 0 ; i < arguments.length; i++){
            switch (arguments[i]){
                case "f":
                    anser[i] = Direction.Forward;
                    break;
                case "b":
                    anser[i] = Direction.Backward;
                    break;
                case "r":
                    anser[i] = Direction.Right;
                    break;
                case "l":
                    anser[i] = Direction.Left;
                    break;
                default:
                    break;
            }
        }
        return anser;
    }
}

