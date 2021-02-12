package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final Cell[][] cells;

    public Grid(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.cells = new Cell[numberOfRows][numberOfColumns];
    }

    public Grid(Grid grid) {
        this.numberOfRows = grid.numberOfRows;
        this.numberOfColumns = grid.numberOfColumns;
        this.cells = grid.cells.clone();
    }

    /**
     * Create an initial grid of random number of rows and columns in the range [5-20]
     *
     * @return a grid of random number of rows and columns in the range [5-20] filled randomly with 0s and 1s
     */
    public static Grid Init() {
        Random random = new Random();
        Grid grid = new Grid(5 + random.nextInt(16), 5 + random.nextInt(16));
//        Grid grid = new Grid(5 , 5 + random.nextInt(5));
        grid.fill();
        return grid;
    }

    /**
     * Fill the grid randomly with 0s and 1s
     */
    private void fill() {
        Random random = new Random();
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                this.cells[i][j] = new Cell(random.nextBoolean() ? '1' : '0', new Coordinate(i, j));
            }
        }
    }

    public Cell getCell(Coordinate coordinate) {
        return this.cells[coordinate.getRow()][coordinate.getColumn()];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public List<Cell> getNeighbors(Cell cell) {
        List<Cell> cells = new ArrayList<>();
        Coordinate coordinate = cell.getCoordinate();
        if (coordinate.getRow() > 0) {
            // above
            cells.add(this.cells[coordinate.getRow() - 1][coordinate.getColumn()]);
            if (coordinate.getColumn() > 0) {// above left
                cells.add(this.cells[coordinate.getRow() - 1][coordinate.getColumn() - 1]);
            }
            if (coordinate.getColumn() < this.numberOfColumns - 1) {// above right
                cells.add(this.cells[coordinate.getRow() - 1][coordinate.getColumn() + 1]);
            }
        }
        if (coordinate.getRow() < this.numberOfRows - 1) {
            //below
            cells.add(this.cells[coordinate.getRow() + 1][coordinate.getColumn()]);
            if (coordinate.getColumn() > 0) {// below left
                cells.add(this.cells[coordinate.getRow() + 1][coordinate.getColumn() - 1]);
            }
            if (coordinate.getColumn() < this.numberOfColumns - 1) {// below right
                cells.add(this.cells[coordinate.getRow() + 1][coordinate.getColumn() + 1]);
            }
        }
        if (coordinate.getColumn() > 0) {// left
            cells.add(this.cells[coordinate.getRow()][coordinate.getColumn() - 1]);
        }
        if (coordinate.getColumn() < this.numberOfColumns - 1) {// right
            cells.add(this.cells[coordinate.getRow()][coordinate.getColumn() + 1]);
        }
        return cells;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : this.cells) {
            for (Cell cell : row) {
                sb.append("+---");
            }
            sb.append("+\n");
            for (Cell cell : row) {
                sb.append("| " + cell.getValue() + " ");
            }
            sb.append("|\n");
        }
        for (Cell ignored : this.cells[0]) {
            sb.append("+---");
        }
        sb.append("+\n");
        return sb.toString();
    }
}
