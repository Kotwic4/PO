package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

public class Car {
    private MapDirection direction;
    private Position position;

    public Car(){
        this.direction = MapDirection.North;
        this.position = new Position(2,2);
    }
    public String toString(){
        return "Orietnacja : " + this.direction.toString() + " Pozycja : " + this.position.toString();
    }

    public void move(MoveDirection direction){
        switch(direction){
            case Left:
                this.direction = this.direction.previous();
                break;
            case Right:
                this.direction = this.direction.next();
                break;
            case Forward:
                move(true);
                break;
            case Backward:
                move(false);
                break;
        }
    }

    private void move(boolean forward){
        int deltaChange = forward ? 1 : -1;
        Position deltaPosition;
        switch(this.direction){
            case North:
                deltaPosition = new Position(0,deltaChange);
                break;
            case South:
                deltaPosition = new Position(0,-deltaChange);
                break;
            case West:
                deltaPosition = new Position(-deltaChange,0);
                break;
            case East:
                deltaPosition = new Position(deltaChange,0);
                break;
            default:
                deltaPosition = new Position(0,0);
                break;
        }
        Position updatedPosition = this.position.add(deltaPosition);
        if(inBoundries(updatedPosition)) this.position = updatedPosition;
    }

    private boolean inBoundries(Position position){
        return position.smaller(new Position(4,4)) && position.greater(new Position(0,0));
    }

}

