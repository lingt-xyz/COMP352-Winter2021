package p1;

import java.util.ArrayList;
import java.util.List;

public class Version1 {
    private Row row;

    public Version1(Row row){
        this.row = row;
    }

    public void unHide() {
        // print out the original content
        System.out.println(this.row);

        List<Row> unHideRows = new ArrayList<>();
        unHideRows.add(this.row);
        for (int i = 0; i < this.row.size(); i++) {
            if(this.row.get(i).equals(Cell.Pound)){
                // duplicate the unHideRows
                int size = unHideRows.size();
                for (int j = 0; j < size; j++) {
                    Row r = unHideRows.get(j);
                    // duplicate the row
                    Row newRow = new Row(r);
                    unHideRows.add(newRow);
                    // update content
                    r.set(i, Cell.Nought);
                    newRow.set(i, Cell.Cross);
                }
            }
        }
        unHideRows.forEach(System.out::println);
    }
}
