import java.util.Stack;

public final class Stacks {
    public static void main(String[] args) {
        System.out.println(istPalindrom("hey"));
        System.out.println(istPalindrom("hallo"));
        System.out.println(istPalindrom("rentner"));
        System.out.println(istPalindrom("lagerregal"));
    }

    public static boolean istPalindrom(String str) {
        // Palindrom = vorwärt & rückwärts gelesen gleich
        // Beispiele: Rentner, Lagerregal
        Stack<Character> stack = new Stack<>();

        int mitte = str.length() / 2;

        // Bis zur Mitte immer pushen
        for (int i = 0; i < mitte; i++) {
            stack.push(str.charAt(i));
        }

        int start = mitte;
        // Wenn ungerade Anzahl an Zeichen, überspringe das mittlere
        // beim Überspringen müssen wir 'mitte + 1' überspringen
        if (str.length() % 2 != 0) {
            start += 1;
        }

        // Poppe und vergleiche ob chars gleich sind
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        // Falls Stack noch Werte beinhaltet, ist etwas schief gelaufen
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
