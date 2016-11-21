package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotwic4 on 21.11.2016.
 */
public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Car> cars = new ArrayList<>();

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
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
        return new MapVisualizer().dump(this,getLowerLeft(),getUpperRight());
    }

    abstract protected Position getLowerLeft();

    abstract protected Position getUpperRight();


}
