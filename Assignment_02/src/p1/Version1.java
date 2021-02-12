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
    public int ExploreAndLabelColony(Grid grid, Coordinate coordinate, char label) {
        Cell cell = grid.getCell(coordinate);
        cell.setExplored(true);
        int size = 1;
        cell.setValue(label);
        for (Cell c : grid.getNeighbors(cell)) {
            if (!c.isExplored() && c.presence()) {
                size += ExploreAndLabelColony(grid, c.getCoordinate(), label);
            }
        }
        return size;
    }
}
