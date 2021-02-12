package p1;

public class ColonyExplorer {

    public static void main(String[] args) {
        Grid grid = Grid.Init();
        System.out.println(grid);
        System.out.println(FreezeGrid(V1(grid)));
    }

    private static Grid FreezeGrid(Grid grid){
        for (Cell[] row : grid.getCells()) {
            for (Cell cell : row) {
                if(!cell.presence()) {
                    cell.setValue('-');
                }
            }
        }
        return grid;
    }
    private static Grid V1(Grid grid){
        Grid grid1 = new Grid(grid);
        Version1 v1 = new Version1();

        char label = 'A';
        for (Cell[] row : grid1.getCells()) {
            for (Cell cell : row) {
                if(!cell.isExplored() && cell.presence()) {
                    v1.ExploreAndLabelColony(grid, cell.getCoordinate(), label);
                    label++;
                }
            }
        }
        return grid1;
    }
}
