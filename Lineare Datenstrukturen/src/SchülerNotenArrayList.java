/*
 * Ein Lehrer möchte die Zensuren seiner Klasse übersichtlich speichern. Jeder Schüler hat 10 Fächer und die Klasse besteht
 * aus 30 Schülern.
 * Das Geschlecht soll hierbei keine Rolle spielen. Die Namen der Fächer und die Namen der Schüler bleiben hier unberücksichtigt. 
 * 
 * Entwirf einen Algorithmus in verbaler Form zur Abspeicherung der Daten mit Hilfe eines zweidimensionalen Feldes. 
 * Folgende Bedingungen sollen erfüllt werden: 
 *  - Die Noten der Schüler werden zufällig ermittelt. 
 *  - Die Ausgabe der Daten sollte so ungefähr aussehen. 
 *  - Am Ende einer jeden Reihe oder darunter soll die Durchschnittsnote des Schülers angezeigt werden. 
 *  - Ganz am Ende soll die Durchschnittsnote der Klasse angezeigt werden. 
 *  - Die Ausgabe der Noten auf dem Bildschirm sollte wie folgt aussehen (ist nicht unbedingt ein MUSS): 
 */

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class SchülerNotenArrayList {
    public static void main(String[] args) {
        SchülerNotenArrayList sn = new SchülerNotenArrayList();
        // sn.fülleAlleNotenAuf();
        // sn.gebeNotenAus();
        // sn.fülleNotenFürSchülerAuf(0);
    }

    // 1. -> Schüler; 2. -> Fach
    private ArrayList<ArrayList<Integer>> notenJeSchüler;

    public SchülerNotenArrayList() {
        notenJeSchüler = new ArrayList<>();
    }

    private static void compareIntToInteger() {
        // int muss immer einen Wert haben, Integer kann auch 'null' sein
        int a[] = new int[10];
        Integer b[] = new Integer[10];

        for (int i = 0; i < 10; ++i) {
            System.out.println("a" + i + "=" + a[i] + "\t" + "b" + i + "=" + b[i]);
        }
    }

    private static void compareArrayToArrayList() {
        // statische Liste -> Größe fest und nicht anpassbar
        Integer a[] = new Integer[10];
        // dynamische Liste -> Größe passt sich automatisch an, je nach dem, was
        // benötigt wird
        ArrayList<Integer> b = new ArrayList<>();

        // a.length <=> b.size()
        // a[i] <=> b.get(i)
        // a[i] = x <=> b.set(i, x)
        // ... <=> b.add(x) // fügt ein Wert ganz hinten im Feld hinzu
        // ... <=> b.remove(i) // entfernt den Wert beim Index i
        for (int i = 0; i < 10; ++i) {
            System.out.println("a" + i + "=" + a[i] + "\t" + "b" + i + "=" + b.get(i));
        }
    }

    public void fülleNotenFürSchülerAuf(int schüler) {
        for (int i = 0; i < 10; ++i) {
            int note = 1 + (int) (6 * Math.random());
            // ArrayList fügt automatisch ganz hinten die neue Note hinzu
            notenJeSchüler.get(schüler).add(note);
        }
    }

    public void fülleAlleNotenAuf() {
        for (int schüler = 0; schüler < 30; ++schüler) {
            fülleNotenFürSchülerAuf(schüler);
        }
    }

    public double berechneDurchschnittFürSchüler(int schüler) {
        double sum = 0;
        for (int fach = 0; fach < notenJeSchüler.get(schüler).size(); ++fach) {
            sum += notenJeSchüler.get(schüler).get(fach);
        }
        double average = sum / notenJeSchüler.get(schüler).size();
        return average;
    }

    public double berechneDurchschnitt() {
        double sum = 0;
        for (int schüler = 0; schüler < notenJeSchüler.size(); ++schüler) {
            sum += berechneDurchschnittFürSchüler(schüler);
        }
        double average = sum / notenJeSchüler.size();
        return average;
    }

    public void gebeNotenFürSchülerAus(int schüler) {
        System.out.print("Noten für Schueler " + schüler + ":\t");
        for (int i = 0; i < notenJeSchüler.get(schüler).size(); ++i) {
            System.out.print(notenJeSchüler.get(schüler).get(i) + " / ");
        }
        System.out.print("D = " + berechneDurchschnittFürSchüler(schüler));
        System.out.println();
    }

    public ArrayList<Double> berecheDurchschnittJeFach() {
        ArrayList<Double> r = new ArrayList<>();
        for (int fach = 0; fach < 10; ++fach) {
            double durchschnittFach = 0;
            for (int schüler = 0; schüler < notenJeSchüler.size(); ++schüler) {
                int note = notenJeSchüler.get(schüler).get(fach);
                durchschnittFach += note;
            }
            durchschnittFach /= 10;
            r.add(durchschnittFach);
        }
        return r;
    }

    public int bestimmeBestesFach() {
        ArrayList<Double> alleDurchschnitte = berecheDurchschnittJeFach();
        int bestesFach = 0;
        double besteNote = alleDurchschnitte.get(0);
        for (int fach = 1; fach < alleDurchschnitte.size(); ++fach) {
            double note = alleDurchschnitte.get(fach);
            if (note < besteNote) {
                besteNote = note;
                bestesFach = fach;
            }
        }
        return bestesFach;
    }

    public void gebeNotenAus() {
        for (int schüler = 0; schüler < notenJeSchüler.size(); ++schüler) {
            gebeNotenFürSchülerAus(schüler);
        }
        System.out.println("Gesamtdurchschnitt = " + berechneDurchschnitt());
    }

    public void gebeNotenFürWhile() {
        int i = 0;
        while (i < notenJeSchüler.size()) {
            gebeNotenFürSchülerAus(i);
            i++;
        }
        System.out.println("Gesamtdurchschnitt = " + berechneDurchschnitt());
    }
}