package agh.cs.lab5;

import agh.cs.lab2.Position;

/**
 * Created by Kotwic4 on 21.11.2016.
 */
public abstract class AbstractWorldMapElement implements IMapElement{
    protected Position position;

    public Position getPosition(){
        return this.position;
    }

}
