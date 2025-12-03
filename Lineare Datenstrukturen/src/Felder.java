public class Felder {
    private int feld[] = new int[10];
    private int next_index = 0;

    public static void main(String[] args) {
        Felder f = new Felder();
        // for (int x : f.feld) {
        // System.out.println(x);
        // }

        // f.hinzufuegen(3);
        // f.hinzufuegen(6);
        // f.hinzufuegen(6);
        // f.hinzufuegen(6);
        // f.loescheVorne_kommentarlos();
        // f.zeigeFeld();

        f.fuelleZufaellig();
        f.zeigeFeld();
    }

    public void hinzufuegen(int x) {
        if (next_index >= 10)
            return;
        feld[next_index] = x;
        next_index++;
    }

    public void loescheHinten() {
        int zuLoeschen = next_index - 1; // wir löschen eine Stelle vor dem nächsten Index
        if (zuLoeschen < 0) // nichts zu löschen
            return;
        feld[zuLoeschen] = 0;
        // da wir hinterste Stelle gelöscht haben, müssen wir in Zukunft eine Stelle
        // weiter hinten anfangen
        next_index--;
    }

    public void loescheVorne() {
        // feld[0] = 0; // unnötig

        // verschiebe Feld um 1 nach links
        // { 1, 2, 3, 4, 5, 6 }
        // { -, 2, 3, 4, 5, 6 }
        // { 2, 3, 4, 5, 6, - }
        //
        // { -, 3, 4, -, -, - }
        // { 3, 4, -, -, -, - }
        for (int i = 0; i < next_index - 1; ++i) {
            // feld.length - 1 da letzte Stelle nicht überschrieben wird (soll leer werden)
            // for (int i = 0; i < feld.length - 1; ++i) {
            // aktuelle stelle = nächster stelle
            feld[i] = feld[i + 1];
        }

        feld[next_index] = 0; // lösche hinterste stelle (durch verschiebung wirkt wie vorderste)
        next_index--;
    }

    public void loescheVorne_kommentarlos() {
        if (next_index >= 10 || next_index < 0)
            return;

        for (int i = 0; i < next_index - 1; ++i)
            feld[i] = feld[i + 1];
        feld[next_index] = 0;
        next_index--;
    }

    // { 3, 4, -, -, -, - }
    public void zeigeFeld() {
        // Feld:
        // 0 = 3
        // 1 = 4
        // 2 = - <= next_index wäre hier
        // 3 = -
        // 4 = -
        // ...
        System.out.println("Feld:");
        for (int i = 0; i < feld.length; ++i) {
            if (i < next_index)
                System.out.println(i + " = " + feld[i]);
            else
                System.out.println(i + " = -");
        }
    }

    public void fuelleZufaellig() {
        // Wir nehmen Zahlen zwischen 0 und 10
        for (int i = 0; i < feld.length; ++i) {
            int zufallszahl = (int) (10 * Math.random());
            // WICHTIG: Unsere Methode nutzen, sonst wird next_index nicht richtig
            // aktuallisiert
            hinzufuegen(zufallszahl);
        }
    }
}
