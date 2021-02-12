package p1;

public class Cell {
    private char value;
    private Coordinate coordinate;

    public Cell(char value, Coordinate coordinate) {
        this.value = value;
        this.coordinate = coordinate;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean presence(){
        return this.value == '1';
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
