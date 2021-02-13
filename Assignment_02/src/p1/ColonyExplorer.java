package p1;

public class ColonyExplorer {

    public static void main(String[] args) {
        Grid grid = Grid.Init();
        System.out.println(grid);
//        Explore(Version1::ExploreAndLabelColony, grid);
        Explore(Version2::ExploreAndLabelColony, grid);
        FreezeGrid(grid);
        System.out.println(grid);
    }

    private static void Explore(Function fn, Grid grid) {
        char label = 'A';
        for (Cell[] row : grid.getCells()) {
            for (Cell cell : row) {
                if (cell.presence() && !cell.isExplored()) {
                    fn.call(grid, cell.getCoordinate(), label);
                    label++;
                }
            }
        }
    }

    private static Grid FreezeGrid(Grid grid) {
        for (Cell[] row : grid.getCells()) {
            for (Cell cell : row) {
                if (!cell.presence()) {
                    cell.setValue('-');
                }
            }
        }
        return grid;
    }

    @FunctionalInterface
    interface Function {
        void call(Grid grid, Coordinate coordinate, char label);
    }
}
