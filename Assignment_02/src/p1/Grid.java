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
            Cell above = this.cells[coordinate.getRow() - 1][coordinate.getColumn()];
            if (above.presence()) {
                cells.add(above);
            }
            if (coordinate.getColumn() > 0) {// above left
                Cell aboveLeft = this.cells[coordinate.getRow() - 1][coordinate.getColumn() - 1];
                if (aboveLeft.presence()) {
                    cells.add(aboveLeft);
                }
            }
            if (coordinate.getColumn() < this.numberOfColumns - 1) {// above right
                Cell aboveRight = this.cells[coordinate.getRow() - 1][coordinate.getColumn() + 1];
                if (aboveRight.presence()) {
                    cells.add(aboveRight);
                }
            }
        }
        if (coordinate.getRow() < this.numberOfRows - 1) {
            //below
            Cell below = this.cells[coordinate.getRow() + 1][coordinate.getColumn()];
            if (below.presence()) {
                cells.add(below);
            }
            if (coordinate.getColumn() > 0) {// below left
                Cell belowLeft = this.cells[coordinate.getRow() + 1][coordinate.getColumn() - 1];
                if (belowLeft.presence()) {
                    cells.add(belowLeft);
                }
            }
            if (coordinate.getColumn() < this.numberOfColumns - 1) {// below right
                Cell belowRight = this.cells[coordinate.getRow() + 1][coordinate.getColumn() + 1];
                if (belowRight.presence()) {
                    cells.add(belowRight);
                }
            }
        }
        if (coordinate.getColumn() > 0) {// left
            Cell left = this.cells[coordinate.getRow()][coordinate.getColumn() - 1];
            if (left.presence()) {
                cells.add(left);
            }
        }
        if (coordinate.getColumn() < this.numberOfColumns - 1) {// right
            Cell right = this.cells[coordinate.getRow()][coordinate.getColumn() + 1];
            if (right.presence()) {
                cells.add(right);
            }
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
