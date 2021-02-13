package p1;

public class Version1 {

    /**
     * Either label that location and all its neighbors or do nothing,
     * depending on the presence or absence of a cell at the given location, respectively
     *
     * @param grid
     * @param coordinate
     * @return the size of the labeled colony
     */
    public static int ExploreAndLabelColony(Grid grid, Coordinate coordinate, char label) {
        Cell cell = grid.getCell(coordinate);
        cell.setExplored(true);
        cell.setValue(label);
        int size = 1;
        for (Cell c : grid.getNeighbors(cell)) {
            if (!c.isExplored()) {
                size += ExploreAndLabelColony(grid, c.getCoordinate(), label);
            }
        }
        return size;
    }
}
