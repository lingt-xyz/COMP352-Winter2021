package p1;

public class Cell {
    private char value;
    private Coordinate coordinate;
    private boolean explored;

    public Cell(char value, Coordinate coordinate) {
        this.value = value;
        this.coordinate = coordinate;
        this.explored = false;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean presence(){
        return this.value != '0';
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
