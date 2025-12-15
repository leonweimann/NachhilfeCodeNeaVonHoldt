public class EinfacheRekursion {
    public static void main(String[] args) {
        System.out.println(summeR(2, 3));
    }

    // --- Potenzen ---

    // a^b
    public static int potenzI(int a, int b) {
        int r = 1;
        for (int i = 0; i < b; i++)
            r *= a;
        return r;
    }

    /*
     * Rekursion:
     * - Rekursionsende
     * - Rekursionsschritt
     * --> Unser Problem in ein kleineres zerlegen
     * 
     * a^b = a * a^(b-1)
     * 2^3 = 2 * 2^2 = 2 * 2 * 2^1 = 2 * 2 * 2 * 2^0
     */
    public static int potenzR(int a, int b) {
        if (b <= 0)
            return 1;
        return a * potenzR(a, b - 1);
    }

    // --- Fakultaet ---

    public static int fakultaetI(int n) {
        int r = 1;
        // for (int i = n; i > 0; i--)
        for (int i = 2; i < n; i++)
            r *= i;
        return r;
    }

    /*
     * Bsp.: 5! = 5 * 4 * 3 * 2 * 1
     * ----> n! = n * (n-1)! = ...
     */
    public static int fakultaetR(int n) {
        if (n == 0)
            return 1;
        return n * fakultaetR(n - 1);
    }

    // --- Summe ---

    /*
     * a(n) := ∑a ; n-mal
     * 
     * Bsp.: a = 2, n = 3 => 2 + 2 + 2
     * a(n) = a + a(n-1) = ...
     */
    public static int summeR(int a, int n) {
        if (n == 0)
            return 0;
        return a + summeR(a, n - 1);
    }
}
