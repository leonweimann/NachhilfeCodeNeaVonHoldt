import java.util.ArrayList;

/**
 * Es gibt
 * - Zustaende, zwischen welchen der Automat wechselt.
 * - genau einen Startzustand.
 * - genau einen Endzustand (Vereinfachung).
 * - eine Übergangsfunktion (implementiert uebergaenge / Folgetafel)
 */
public class Automat {
    private ArrayList<Zustand> zustaende;
    private Zustand start;
    private Zustand ende;
    private ArrayList<Uebergang> uebergaenge;
    private Zustand aktuell;

    public Automat(Zustand zustaende[], Zustand start, Zustand ende) {
        this.zustaende = new ArrayList<>();
        for (int i = 0; i < zustaende.length; i++) {
            this.zustaende.add(zustaende[i]);
        }
        this.uebergaenge = new ArrayList<>();

        this.start = start;
        this.ende = ende;
        this.aktuell = start;
    }

    public ArrayList<Zustand> zustaende() {
        return this.zustaende;
    }

    public Zustand start() {
        return this.start;
    }

    public Zustand ende() {
        return this.ende;
    }

    public Zustand aktuell() {
        return this.aktuell;
    }

    public void addUebergang(Zustand eingang, Zustand ausgang, String eingabe) {
        uebergaenge.add(new Uebergang(eingang, ausgang, eingabe));
    }

    public Zustand naechsterZustand(String eingabe) {
        // Finde in allen uebergaengen den Übergang, wo:
        // - Eingangszustand = aktueller Zustand
        // - Eingabe = Eingabe

        for (int i = 0; i < uebergaenge.size(); i++) {
            Uebergang ü = uebergaenge.get(i);
            if (ü.eingangsZustand().name() == aktuell.name() && ü.eingabe() == eingabe) {
                aktuell = ü.ausgangsZustand();
                break;
            }
        }

        return aktuell;
    }
}
