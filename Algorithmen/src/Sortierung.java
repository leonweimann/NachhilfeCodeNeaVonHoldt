import java.util.ArrayList;

public class Sortierung {
    public static void main(String[] args) {
        int arr[] = {43, 20, 10, 12, 60, 50, 17, 80, 93, 54, 67, 18, 25};
//        int arr[] = { 3, 2, 9, 1 };
        printArray(arr);

//        mergeSort(arr);

        quicksortTimed(arr);

        printArray(arr);
    }

    /*
     * Start: [3, 2, 9, 1]
     *
     * [2, 3, 9, 1] // 3 steigt solange auf, bis eine größere Zahl (9) kommt
     * [2, 3, 1, 9] // im selben Schritt steigt dann die 9 auf
     *
     * [2, 1, 3, 9]
     *
     * [1, 2, 3, 9] // 2 steigt auf
     *
     * Ende: [1, 2, 3, 9]
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tauschen(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortArrayList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    tauschenArrayList(arr, j, j + 1);
                }
            }
        }
    }

    /*
     * [8, 5, 9, 2, 1, 3] <- Eingabe
     *
     * [1,|5, 9, 2, 8, 3] <- 1 <=> 8
     * [1, 2,|9, 5, 8, 3] <- 2 <=> 5
     * ...
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j;
                }
            }
            tauschen(arr, i, minI);
        }
    }

    public static void selectionSortArrayList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int minI = i;
            for (int j = i + 1; i < arr.size(); j++) {
                if (arr.get(j) < arr.get(minI)) {
                    minI = j;
                }
            }
            tauschenArrayList(arr, i, minI);
        }
    }

    /*
     * [8, 5, 9, 2, 1, 3]
     * [8, 5, 9][2, 1, 3]
     * [8][5, 9][2][1, 3]
     * ...[5][9]...[1][3]
     *
     * MERGE:
     * [8][5, 9][2][1, 3]
     * [5, 8, 9][1, 2, 3]
     * [1, 2, 3, 5, 8, 9]
     */
    public static void mergeSort(int[] arr) {
        mergeSortR(arr, 0, arr.length - 1);
    }

    private static void mergeSortR(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int m = (l + r) / 2;
        mergeSortR(arr, l, m);
        mergeSortR(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    // [3, 5, 9][1, 2, 8]
    private static void merge(int[] arr, int l, int m, int r) {
        int copy[] = new int[r - l + 1]; // oder einfach arr.length, das passt auch immer
        int copyIndex = 0;

        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                copy[copyIndex] = arr[i];
                copyIndex++;
                i++;
            } else {
                copy[copyIndex] = arr[j];
                copyIndex++;
                j++;
            }
        }

        for (int ii = i; ii <= m; ii++) {
            copy[copyIndex] = arr[ii];
            copyIndex++;
        }
        for (int jj = j; jj <= r; jj++) {
            copy[copyIndex] = arr[jj];
            copyIndex++;
        }

        for (int x = l; x <= r; x++) {
            arr[x] = copy[x - l]; // x - l, da wir in copy von 0 zählen, in arr aber ab l (Anfang links)
        }
    }

    /*
        Start = [43, 20, 10, 12, 60, 50, 17, 80, 93, 54, 67, 18, 25]
        1.  Pivot = 43
            <43: [20, 10, 12, 17, 18, 25]
            >43: [60, 50, 80, 93, 54, 67]
            =>:  [20, 10, 12, 17, 18, 25] 43 [60, 50, 80, 93, 54, 67]

        2. Pivot = 20 (linker Teil von 1.) [20, 10, 12, 17, 18, 25]
            <20: [10, 12, 17, 18]
            >20: [25]
            =>:  [10, 12, 17, 18] 20 [25]

        3. Pivot = 10 (linken Teil von 2.) [10, 12, 17, 18]
            <10: []
            >10: [12, 17, 18]
            =>:  10 [12, 17, 18]

        4. Pivot = 12 (rechter Teil von 3.) [12, 17, 18]
            <12: []
            >12: [17, 18]
            =>:  12 [17, 18]

        5. Pivot = 17 (rechter Teil von 4.) [17, 18]
            <17: []
            >17: [18]
            =>:  17 [18]
            ==>: [10, 12, 17, 18, 20, 25]

        6. Pivot = 60 (rechter Teil von 1.) [60, 50, 80, 93, 54, 67]
            <60: [50, 54]
            >60: [80, 93, 67]
            =>:  [50, 54] 60 [80, 93, 67]

        7. Pivot = 50 (linker Teil von 6.) [50, 54]
            <50: []
            >50: [54]
            =>:  50 [54]

        8. Pivot = 80 (rechter Teil von 6.) [80, 93, 67]
            <80: [67]
            >80: [93]
            =>:  [67] 80 [93]
            ==>: [50, 54, 60, 67, 80, 93]

        Ende = [10, 12, 17, 18, 20, 25, 50, 54, 60, 67, 80, 93]

        ---

        Pivot:
        Hier teilen wir unser zu sortierendes Array in zwei Teile auf.
        Er kann beliebig in jedem Schritt gewählt werden. Hier der Einfachheit wegen
        immer das erste Element des Teilarrays.

        Eigenschaften:
        Durchschnittliche Laufzeit: O(n log n)
        Worst Case: O(n^2) (z.B. wenn Pivot immer genau in der Mitte der Zahlenwerte liegt)

        Speicherbedarf: O(log n) durch Rekursion

        Wichtig:
        Die Wahl des Pivot ist wichtig dafür, ob Worst-Case eintritt. Man könnte
        das Pivot Element immer zufällig wählen, jedoch:
        - dauert jeder Schritt länger
            - Mehr Schritte die weniger Zeit benötigen, gehen deutlich schneller
        - insgesamt langsamer als feste Position

        Mit Random Pivot: 0,00011..
        Mit festem Pivot: 0,000004375...
        => Random ist ca. >25x langsamer als festes Pivot
     */
    public static void quicksort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                tauschen(arr, i, j);
            }
        }
        tauschen(arr, i + 1, r);

        quicksort(arr, l, i);
        quicksort(arr, i + 1, r);
    }

    public static void quicksortTimed(int[] arr) {
        double start = System.nanoTime();

        quicksort(arr, 0, arr.length - 1);

        double end = System.nanoTime();
        double duration = (end - start) / 1000000000;
        System.out.println("Dauer: " + duration + " Sekunden");
    }

    // --- Hilfszeugs ---

    public static int getMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static void tauschen(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void tauschenArrayList(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, j);
        arr.set(i, temp);
    }

    private static void printArray(int[] arr) {

        for (int a : arr)
            System.out.print(a + ", ");
        System.out.println();
    }
}
