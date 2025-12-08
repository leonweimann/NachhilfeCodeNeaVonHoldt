import java.util.ArrayList;
import java.util.Stack;

public class TermInterpreter {
    public static void main(String[] args) {
        String input = "3*2*4-5*2+1";
        int result = evaluate(input);
        System.out.println(result);

        System.out.println(isValid("([{()}])(){()}")); // true
        System.out.println(isValid("([{()}])(){(})")); // false
    }

    /*
     * Berechnet den Ausdruck bspw. 3*2*4-5*2+1 und gibt das Ergebnis 15 zurück
     */
    public static int evaluate(String expr) {
        expr = expr.replace(" ", "");

        // { 3, *, 2, *, 4, -, 5, *, 2, +, 1 }
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.toCharArray()[i];
            if (Character.isDigit(c)) {
                // Wenn wir eine Ziffer haben, zwischenspeichern wir diese im numbers Buffer
                numbers.append(c);
            } else {
                // Wenn etwas anderes kommt (*, /, +, -), dann speichern wir alle Ziffern im
                // Buffer und speichern den Operator
                tokens.add(numbers.toString());
                numbers.setLength(0); // StringBuilder clearen
                tokens.add(String.valueOf(c));
            }
        }
        tokens.add(numbers.toString()); // Reste von numbers anhängen

        System.out.println(tokens.toString());

        // 1. Durchlauf: * und / auswerten
        // { 24, -, 10, +, 1 }
        ArrayList<String> firstPass = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()) {
            String t = tokens.get(i);

            if (t.equals("*") || t.equals("/")) {
                int left = Integer.parseInt(firstPass.remove(firstPass.size() - 1));
                int right = Integer.parseInt(tokens.get(++i));
                int result = t.equals("*") ? left * right : left / right;
                firstPass.add(String.valueOf(result));
            } else {
                firstPass.add(t);
            }

            i++;
        }

        System.out.println(firstPass.toString());

        // 2. Durchlauf: + und - auswerten
        // => 15
        int result = Integer.parseInt(firstPass.get(0));
        i = 1;
        while (i < firstPass.size()) {
            String op = firstPass.get(i++);
            int right = Integer.parseInt(firstPass.get(i++));

            if (op.equals("+")) {
                result += right;
            } else {
                result -= right;
            }
        }

        return result;
    }

    /*
     * Klammern auswerten: expr="{()}"
     * Ob jede öffnende Klammer eine passende schließende hat.
     * 
     * D.h. "{{}}()" ist gültig (return true)
     * ---- "{){]" ist ungültig (return false)
     */
    public static boolean isValid(String expr) {
        char chars[] = expr.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
