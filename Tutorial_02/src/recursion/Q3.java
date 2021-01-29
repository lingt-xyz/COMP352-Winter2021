package recursion;

import java.util.Random;

public class Q3 {
    /**
     * Give a recursive algorithm to compute the product of two positive integers, m and n, using only addition and subtraction.
     * @param m a positive integer
     * @param n a positive integer
     * @return the product of {@code m} and {@code n}
     */
    public static int Product(int m, int n) {
        if (m == 0) {
            return 0;
        } else {
            return n + Product(m - 1, n);
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int m = r.nextInt(10);
            int n = r.nextInt(10);
            System.out.println(String.format("%s*%s=%s", m, n, Product(m, n)));
        }
    }
}
