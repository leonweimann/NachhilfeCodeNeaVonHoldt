import java.util.ArrayList;

public class Sortierung {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 9, 1 };
        printArray(arr);

        bubbleSort(arr);

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
