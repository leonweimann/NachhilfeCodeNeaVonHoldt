package ab_stack;

import java.util.Stack;

public class Bahnhof {
    public static void main(String[] args) {
        Bahnhof bh = new Bahnhof();
        bh.füllen();
        bh.ausgeben(bh.gleis1);
        bh.sortieren();
        bh.ausgeben(bh.gleis1); // soll leer sein
        bh.ausgeben(bh.gleis2); // nur rote
        bh.ausgeben(bh.gleis3); // nur blaue
    }

    private Stack<Waggon> gleis1;
    private Stack<Waggon> gleis2;
    private Stack<Waggon> gleis3;

    public Bahnhof() {
        gleis1 = new Stack<>();
        gleis2 = new Stack<>();
        gleis3 = new Stack<>();
    }

    /*
     * Füllt Gleis1 mit zufälligen Waggonfarben (blau oder rot)
     */
    public void füllen() {
        Waggon blau = new Waggon("blau");
        Waggon rot = new Waggon("rot");

        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.5) {
                gleis1.push(blau);
            } else {
                gleis1.push(rot);
            }
        }
    }

    /*
     * Nimmt alle Züge vom Gleis1 und schiebt die roten auf 2, blauen auf 3
     */
    public void sortieren() {
        while (!gleis1.isEmpty()) {
            Waggon currentWaggon = gleis1.pop();
            String farbe = currentWaggon.getFarbe();
            if (farbe == "rot") {
                gleis2.push(currentWaggon);
            } else {
                gleis3.push(currentWaggon);
            }
        }
    }

    /*
     * Gibt ein Gleis aus im Format "blau - rot - rot - ..."
     */
    public void ausgeben(Stack<Waggon> gleis) {
        for (int i = 0; i < gleis.size(); i++) {
            Waggon w = gleis.get(i);
            if (i > 0) {
                System.out.print(" - ");
            }
            System.out.print(w.getFarbe());
        }
        System.out.println();
    }
}