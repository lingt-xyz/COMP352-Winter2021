package p1;

public class Tictactoe {

    public static void main(String[] args) {
        Row r = new Row(3, 10, 3);
//        RecursiveMethod(r);
        IterativeMethod(r);
    }

    private static void RecursiveMethod(Row r){
        Version1 v1 = new Version1(r);
        v1.unHide();
    }

    private static void IterativeMethod(Row r){
        Version2 v2 = new Version2(r);
        System.out.println(r);
        v2.unHide(r, 0, true);
    }
}
