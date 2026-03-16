import java.util.ArrayList;

/**
 * Es gibt
 * - Zustände, zwischen welchen der Automat wechselt.
 * - genau einen Startzustand.
 * - genau einen Endzustand (Vereinfachung).
 * - eine Übergangsfunktion (implementiert Übergänge / Folgetafel)
 */
public class Automat {
    private ArrayList<Zustand> zustände;
    private Zustand start;
    private Zustand ende;
    private ArrayList<Übergang> übergänge;
    private Zustand aktuell;

    public Automat(Zustand zustände[], Zustand start, Zustand ende) {
        this.zustände = new ArrayList<>();
        for (int i = 0; i < zustände.length; i++) {
            this.zustände.add(zustände[i]);
        }
        this.übergänge = new ArrayList<>();

        this.start = start;
        this.ende = ende;
        this.aktuell = start;
    }

    public ArrayList<Zustand> zustände() {
        return this.zustände;
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

    public void addÜbergang(Zustand eingang, Zustand ausgang, String eingabe) {
        übergänge.add(new Übergang(eingang, ausgang, eingabe));
    }

    public Zustand nächsterZustand(String eingabe) {
        // Finde in allen Übergängen den Übergang, wo:
        // - Eingangszustand = aktueller Zustand
        // - Eingabe = Eingabe

        for (int i = 0; i < übergänge.size(); i++) {
            Übergang ü = übergänge.get(i);
            if (ü.eingangsZustand().name() == aktuell.name() && ü.eingabe() == eingabe) {
                aktuell = ü.ausgangsZustand();
                break;
            }
        }

        return aktuell;
    }
}
