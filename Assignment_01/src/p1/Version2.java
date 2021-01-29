package p1;

import java.util.ArrayList;
import java.util.List;

public class Version2 {

    public List<Row> unHideRows = new ArrayList<>();
    private Row row;

    public Version2(Row row) {
        this.row = row;
        this.unHideRows.add(new Row(new ArrayList<>()));
    }

    /**
     *
     * @param row row to be further examined
     * @param startIndex index to start to exam
     * @param base indicates whether the row is the original row
     */
    void unHide(Row row, int startIndex, boolean base) {
        if (startIndex == row.size()) {
            if (base) {
                System.out.println(row);
            }
        } else {
            if (row.get(startIndex).equals(Cell.Pound)) {
                // duplicate the row
                Row newRow = new Row(row);

                // update content
                row.set(startIndex, Cell.Nought);
                newRow.set(startIndex, Cell.Cross);

                // this is a newly created row, so set base to false
                unHide(newRow, startIndex + 1, false);
                System.out.println(newRow);
            }
            unHide(row, startIndex + 1, base);
        }
    }
}
