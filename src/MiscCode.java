public class MiscCode {
    public static void Fibonacci(int x) {
        /* Print the Fibonacci sequence for values <= x */
        int lo = 1, hi = 1;
        System.out.print(lo + " ");

        while (hi <= x) {
            System.out.print(hi + " ");
            hi = lo + hi;
            lo = hi - lo;
        }
        System.out.println();
    }
}
