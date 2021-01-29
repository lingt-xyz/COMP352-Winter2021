package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Cell {
    Nought("O"),
    Cross("X"),
    Pound("#");

    private final String label;

    Cell(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}

public class Row extends ArrayList<Cell>{

    public Row(List<Cell> row){
        super(row);
    }

    /**
     * Randomly generate a row filled with the given number of pounds at random positions.
     *
     * @param lowerBound the min length of the row, inclusive
     * @param upperBound the max length of the row, exclusive
     * @param numberOfPound the number of pounds in the row
     */
    public Row(int lowerBound, int upperBound, int numberOfPound) {
        Random r = new Random();

        // randomly generate the size of the row
        int size = lowerBound + r.nextInt(upperBound - lowerBound);

        // randomly fill cells with noughts and crosses
        for (int i = 0; i < size; i++) {
            if (r.nextInt(2) == 0) {
                this.add(Cell.Nought);
            } else {
                this.add(Cell.Cross);
            }
        }

        // randomly fill cells with pounds
        for (int i = numberOfPound; i > 0; i--) {
            int index = r.nextInt(size);
            if (this.get(index).equals(Cell.Pound)) {
                i++;
            } else {
                this.set(index, Cell.Pound);
            }
        }
    }
}
