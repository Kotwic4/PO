package agh.cs.lab2;

public enum MapDirection {

    North,East,South,West;

    public String toString(){
        switch(this) {
            case North: return "Północ";
            case East: return "Wschód";
            case South: return "Południe";
            case West: return "Zachód";
            default: return null;
        }
    }

    public MapDirection next(){
        return MapDirection.values()[(this.ordinal()+1)%4];
    }

    public MapDirection previous(){
        return MapDirection.values()[(this.ordinal()+3)%4];
    }

}
