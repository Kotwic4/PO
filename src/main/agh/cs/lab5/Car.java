package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.IWorldMap;

public class Car extends AbstractWorldMapElement{

    private agh.cs.lab4.MapDirection direction;
    private IWorldMap map;

    public Car(IWorldMap map){
        this.direction = agh.cs.lab4.MapDirection.North;
        this.position = new Position(2,2);
        this.map = map;
    }

    public Car(IWorldMap map, int x, int y){
        this.direction = agh.cs.lab4.MapDirection.North;
        this.position = new Position(x,y);
        this.map = map;
    }

    public String toString(){
        return this.direction.toStringFirt();
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
        if(map.canMoveTo(updatedPosition)){
            this.position = updatedPosition;
        }
    }

}

