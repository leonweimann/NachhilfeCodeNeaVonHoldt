import java.util.ArrayList;

public class Sortierung {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 9, 1 };
        printArray(arr);

        selectionSort(arr);

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

    /*
     * [8, 5, 9, 2, 1, 3]
     * [8, 5, 9][2, 1, 3]
     * [8][5, 9][2][1, 3]
     * [8][5][9][2][1][3]
     */
    public static void mergeSort(int[] arr) {
        mergeSortR(arr, 0, arr.length - 1);
    }

    private static void mergeSortR(int[] arr, int l, int r) {
        if (l <= r)
            return;

        int m = (l + r) / 2;
        mergeSortR(arr, l, m);
        mergeSortR(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    // [3, 5, 9][1, 2, 8]
    private static void merge(int[] arr, int l, int m, int r) {
        int copy[] = new int[arr.length];
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

        for (int ii = i; i < l; ii++) {
            copy[copyIndex] = arr[ii];
            copyIndex++;
        }
        for (int jj = j; j < l; jj++) {
            copy[copyIndex] = arr[jj];
            copyIndex++;
        }

        for (int x = l; x < r; x++) {
            arr[x] = copy[x - l];
        }
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
