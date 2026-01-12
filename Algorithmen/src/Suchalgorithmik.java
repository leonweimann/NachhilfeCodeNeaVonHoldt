import java.util.ArrayList;

public class Suchalgorithmik {
    public static void main(String[] args) {
        int test[] = { 9, 3, 1, 5, 7, 3, 8 };
        int x = 1;
        int index = lineareSuche(test, x);
        System.out.println("Zahl " + x + " steht an der Stelle " + index + ".");

        System.out.print("Zahl 3 steht an den Stellen: ");
        int[] all = findeAlle(test, 3);
        for (int i = 0; i < all.length; i++) {
            if (i > 0)
                System.out.print(" / ");
            System.out.print(all[i]);
        }
        System.out.println();
    }

    /*
     * Sucht das Element n in dem Array und gibt den Index dieses zurück.
     */
    public static int lineareSuche(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i; // sobald etwas gefunden wurde, zurückgeben (beendet Schleife / Methode)
            }
        }
        return -1; // n nicht in arr gefunden
    }

    /*
     * Wie eine Lineare Suche, bricht jedoch nicht ab, sondern findet alle Stelle,
     * wo n vorkommt.
     * 
     * Nutzt eine ArrayList, da wir nicht wissen, wie viele Ergebnisse wir finden.
     * Konvertiert diese dann zu einem normalen Array.
     */
    public static int[] findeAlle(int[] arr, int n) {
        ArrayList<Integer> stellen = new ArrayList<>(); // da wir nicht wissen, wie viele Elemente wir haben werden..
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                stellen.add(i);
            }
        }

        // Von ArrayList zu Array ...
        int s[] = new int[stellen.size()];
        for (int i = 0; i < s.length; i++)
            s[i] = stellen.get(i);

        return s;
    }

    public static int binäreSuche(int[] arr, int n) {
        return binäreSucheR(arr, n, 0, arr.length);
    }

    /*
     * Geht nur, wenn die Eingabe sortiert ist!
     */
    private static int binäreSucheR(int[] arr, int n, int l, int r) {
        if (r < 1) {
            return -1; // n nicht gefunden
        }

        int m = (l + r) / 2; // mitte berechnen

        if (arr[m] == n) { // gefunden
            return m;
        } else if (arr[m] < n) { // suche rechts weiter
            return binäreSucheR(arr, n, m + 1, r);
        } else { // suche links weiter
            return binäreSucheR(arr, n, l, m - 1);
        }
    }
}
