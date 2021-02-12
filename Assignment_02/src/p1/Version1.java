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
    public int ExploreAndLabelColony(Grid grid, Coordinate coordinate) {
        Cell cell = grid.getCell(coordinate);
        int colony = 0;
        if (cell.presence()) {
            for (Cell c : grid.getNeighbors(cell)) {
                if (c.presence()) {
                    colony++;
                }
            }
        }
        return colony;
    }
}
