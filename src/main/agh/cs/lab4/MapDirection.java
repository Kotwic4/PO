package agh.cs.lab4;

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

    public String toStringFirt(){
        switch(this) {
            case North: return "N";
            case East: return "E";
            case South: return "S";
            case West: return "W";
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
