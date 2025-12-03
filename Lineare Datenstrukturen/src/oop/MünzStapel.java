package oop;

import java.util.Stack;

public class MünzStapel {
    public static void main(String[] args) {
        MünzStapel ms = new MünzStapel();

        System.out.println();

        Stack<Münze> smz = ms.getEingabe(20);
        ms.sortieren(smz);

        ms.ausgeben();
    }

    private Stack<Münze> stapel1; // 1ct
    private Stack<Münze> stapel2; // 2ct
    private Stack<Münze> stapel3; // 5ct
    private Stack<Münze> stapel4; // 10ct
    private Stack<Münze> stapel5; // 20ct
    private Stack<Münze> stapel6; // 50ct
    private Stack<Münze> stapel7; // 1EUR

    public MünzStapel() {
        stapel1 = new Stack<>();
        stapel2 = new Stack<>();
        stapel3 = new Stack<>();
        stapel4 = new Stack<>();
        stapel5 = new Stack<>();
        stapel6 = new Stack<>();
        stapel7 = new Stack<>();
    }

    public void sortieren(Stack<Münze> eingabe) {
        while (!eingabe.isEmpty()) { // sortiere solange die Eingabe noch Münzen hat
            Münze m = eingabe.pop(); // nimm die oberste Münze raus und sortiere sie zu
            if (1 == m.getWert())
                stapel1.push(m);
            else if (2 == m.getWert())
                stapel2.push(m);
            else if (5 == m.getWert())
                stapel3.push(m);
            else if (10 == m.getWert())
                stapel4.push(m);
            else if (20 == m.getWert())
                stapel5.push(m);
            else if (50 == m.getWert())
                stapel6.push(m);
            else if (100 == m.getWert())
                stapel7.push(m);
        }
    }

    public void ausgeben() {
        printStapelX(1, stapel1);
        printStapelX(2, stapel2);
        printStapelX(3, stapel3);
        printStapelX(4, stapel4);
        printStapelX(5, stapel5);
        printStapelX(6, stapel6);
        printStapelX(7, stapel7);
    }

    private void printStapelX(int x, Stack<Münze> s) {
        System.out.print("Stapel " + x + ":\t");
        for (int i = 0; i < s.size(); i++) {
            if (i > 0)
                System.out.print(" / ");
            System.out.print(s.get(i));
        }
        System.out.println();
    }

    public Stack<Münze> getEingabe(int n) {
        Stack<Münze> ms = new Stack<>();

        for (int i = 0; i < n; ++i) {
            int mz = (int) (7 * Math.random());
            switch (mz) {
                case 0:
                    ms.push(new Münze(1));
                    break;
                case 1:
                    ms.push(new Münze(2));
                    break;
                case 2:
                    ms.push(new Münze(5));
                    break;
                case 3:
                    ms.push(new Münze(10));
                    break;
                case 4:
                    ms.push(new Münze(20));
                    break;
                case 5:
                    ms.push(new Münze(50));
                    break;
                case 6:
                    ms.push(new Münze(100));
                    break;
                default:
                    break;
            }
        }

        return ms;
    }
}