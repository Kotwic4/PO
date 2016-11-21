package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    Position zero = new Position(0,0);
    Position max;

    public RectangularMap(int width, int height){
        this.max = new Position(width,height);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.greater(this.zero) && position.smaller(this.max) && super.canMoveTo(position);
    }

    @Override
    protected Position getLowerLeft() {
        return zero;
    }

    @Override
    protected Position getUpperRight() {
        return max;
    }
}
