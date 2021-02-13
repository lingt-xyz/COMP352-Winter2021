package p1;

import java.util.Stack;

public class Version2 {
    public static int ExploreAndLabelColony(Grid grid, Coordinate coordinate, char label) {
        Cell cell = grid.getCell(coordinate);
        Stack<Cell> stack = new Stack<>();
        cell.setExplored(true);
        stack.push(cell);
        int size = 0;
        while (!stack.empty()) {
            Cell c = stack.pop();
            size++;
            c.setValue(label);
            for (Cell t : grid.getNeighbors(c)) {
                if (!t.isExplored()) {
                    t.setExplored(true);
                    stack.push(t);
                }
            }
        }
        return size;
    }
}
