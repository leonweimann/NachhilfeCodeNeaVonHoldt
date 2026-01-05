public class ErweiterteRekursion {
    public static void main(String[] args) {
        printArray(zähleAugenzahlenI(1000));
    }

    /*
     * Fakultät, wobei nur die ungeraden Zahlen berücksichtigt werden.
     * 
     * z.B. 6! = 5 * 3 * 1
     * oder 7! = 7 * 5 * 3 * 1
     */
    public static int fakultätUngeradeR(int n) {
        // 1. Rekursionsende
        if (n == 1) {
            return 1;
        }
        // 2. Rekursionsschritt
        if (istGerade(n)) {
            // Gehe zum nächsten n (überspringe den 'Rechenschritt')
            // d.h. nur Rekursionsschritt
            return fakultätUngeradeR(n - 1);
        } else {
            // Führe normalen Rekursionsschritt + Rechenschritt aus
            return n * fakultätUngeradeR(n - 1);
        }
    }

    public static boolean istGerade(int x) {
        return x % 2 == 0;
    }

    /*
     * Simuliert das Werfen eines Würfels und gibt die Augenzahl zurück.
     */
    public static int würfeln() {
        return (int) (Math.random() * 6) + 1;
    }

    /*
     * Würfelt und berechnet die Fakultät ungerade von dieser Zahl.
     */
    public static void würfelFakultätUngerade() {
        int x = würfeln();
        int r = fakultätUngeradeR(x);
        System.out.println("Für die gewürfelte Zahl " + x + " ergibt sich der Wert " + r);
    }

    /*
     * Wir würfeln n mal und merken uns für jede Augenzahl, wie oft diese vorkam.
     */
    public static int[] zähleAugenzahlenI(int n) {
        int augenzahlen[] = new int[6];

        for (int i = 0; i < n; i++) {
            int x = würfeln(); // x € [1, 6]
            augenzahlen[x - 1]++;
        }

        return augenzahlen;
    }

    // Schlechter, da die max. Rekursionstiefe von Java schnell erreicht wird ->
    // crash
    // Iterativ kein Limit was das angeht.
    public static int[] zähleAugenzahlenR(int n) {
        int augenzahlen[] = new int[6];
        zähleAugenzahlenRekursion(n, augenzahlen);
        return augenzahlen;
    }

    private static void zähleAugenzahlenRekursion(int n, int augenzahlen[]) {
        if (n <= 0)
            return;

        int x = würfeln(); // x € [1, 6]
        augenzahlen[x - 1]++;

        zähleAugenzahlenRekursion(n - 1, augenzahlen);
    }

    /*
     * z.B. 1 / 2 / 3 / 4 / 5
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                System.out.print(" / ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
