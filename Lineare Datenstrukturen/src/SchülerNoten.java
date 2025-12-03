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
public final class SchülerNoten {
    public static void main(String[] args) {
        SchülerNoten sn = new SchülerNoten();
        sn.fülleAlleNotenAuf();
        sn.gebeNotenAus();
    }

    // 1. -> Schüler; 2. -> Fach
    private int notenJeSchüler[][];

    public SchülerNoten() {
        // Feld speichert 30 Schüler und jeweils 10 Fächer
        notenJeSchüler = new int[30][10];
    }

    public void fülleNotenFürSchülerAuf(int schüler) {
        for (int fach = 0; fach < notenJeSchüler[schüler].length; ++fach) {
            notenJeSchüler[schüler][fach] = 1 + (int) (6 * Math.random());
        }
    }

    public void fülleAlleNotenAuf() {
        for (int schüler = 0; schüler < notenJeSchüler.length; ++schüler) {
            fülleNotenFürSchülerAuf(schüler);
        }
    }

    public double berechneDurchschnittFürSchüler(int schüler) {
        double sum = 0;
        for (int fach = 0; fach < notenJeSchüler[schüler].length; ++fach) {
            sum += notenJeSchüler[schüler][fach];
        }
        double average = sum / notenJeSchüler[schüler].length;
        return average;
    }

    public double berechneDurchschnitt() {
        double sum = 0;
        for (int schüler = 0; schüler < notenJeSchüler.length; ++schüler) {
            sum += berechneDurchschnittFürSchüler(schüler);
        }
        double average = sum / notenJeSchüler.length;
        return average;
    }

    public void gebeNotenFürSchülerAus(int schüler) {
        System.out.print("Noten für Schueler " + schüler + ":\t");
        for (int i = 0; i < notenJeSchüler[schüler].length; ++i) {
            System.out.print(notenJeSchüler[schüler][i] + " / ");
        }
        System.out.print("D = " + berechneDurchschnittFürSchüler(schüler));
        System.out.println();
    }

    public void gebeNotenAus() {
        for (int schüler = 0; schüler < notenJeSchüler.length; ++schüler) {
            gebeNotenFürSchülerAus(schüler);
        }
        System.out.println("Gesamtdurchschnitt = " + berechneDurchschnitt());
    }

    public void gebeNotenFürWhile() {
        int i = 0;
        while (i < notenJeSchüler.length) {
            gebeNotenFürSchülerAus(i);
            i++;
        }
        System.out.println("Gesamtdurchschnitt = " + berechneDurchschnitt());
    }
}