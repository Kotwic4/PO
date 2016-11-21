package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    List<Car> cars;
    Position zero = new Position(0,0);
    Position max;

    public RectangularMap(int width, int height){
        this.max = new Position(width,height);
        this.cars = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.greater(this.zero) && position.smaller(this.max) && !isOccupied(position);
    }

    @Override
    public boolean add(Car car) {
        if(!this.canMoveTo(car.getPosition())) return false;
        this.cars.add(car);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i = 0;
        for(MoveDirection direction : directions){
            cars.get(i).move(direction);
            i = (i+1)%cars.size();
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car car : cars){
            if(car.getPosition().equals(position)) return car;
        }
        return null;
    }

    @Override
    public String toString(){
        return new MapVisualizer().dump(this,zero,max);
    }
}
