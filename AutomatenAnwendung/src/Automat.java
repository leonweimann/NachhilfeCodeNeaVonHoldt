import java.util.ArrayList;
import java.util.Arrays;

/**
 * Es gibt
 * - Zustaende, zwischen welchen der Automat wechselt.
 * - genau einen Startzustand.
 * - Endzustände.
 * - eine Übergangsfunktion (implementiert Uebergaenge / Folgetafel)
 */
public class Automat {
    private ArrayList<Zustand> zustaende;
    private Zustand start;
    private ArrayList<Zustand> enden;
    private ArrayList<Uebergang> uebergaenge;
    private Zustand aktuell;

    public Automat(Zustand[] zustaende, Zustand start, Zustand[] enden) {
        this.zustaende = new ArrayList<>();
        this.zustaende.addAll(Arrays.asList(zustaende));

        this.enden = new ArrayList<>();
        this.enden.addAll(Arrays.asList(enden));

        this.uebergaenge = new ArrayList<>();

        this.start = start;
        this.aktuell = start;
    }

    public ArrayList<Zustand> zustaende() {
        return this.zustaende;
    }

    public Zustand start() {
        return this.start;
    }

    public ArrayList<Zustand> enden() {
        return this.enden;
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

    public boolean istEnde(Zustand z) {
        for (int i = 0; i < enden.size(); i++)
            if (enden.get(i) == z)
                return true;
        return false;
    }

    /**
     * Setzt den Automaten in den Startzustand zurück.
     * - Wenn force == true, dann aktueller Zustand egal.
     * - Sonst nur, wenn im Endzustand.
     * Wenn wir zurücksetzen, bedeutet das, wir setzten den
     * aktuellen Zustand auf den Start zurück.
     */
    public void zuruecksetzen(boolean force) {
        if (istEnde(aktuell) || force) {
            aktuell = start;
        }
    }

    /**
     * Schaut, ob der Automat, so wie er konfiguriert ist, gültig ist.
     * - Endzustand hat akzeptiert keine Eingaben
     * - Jeder Übergang von einem Zustand benötigt eine eindeutige Eingabe
     * - Normale Zustände haben mind. einen Übergang
     */
    public boolean istGueltig() {
        // Endzustand hat keinen Übergang
        boolean endeHatUebergang = false;
        for (int i = 0; i < uebergaenge.size(); i++) {
            Uebergang u = uebergaenge.get(i);
            if (istEnde(u.eingangsZustand())) {
                endeHatUebergang = true;
            }
        }

        // Eingaben sind eindeutig && Zustand hat mind. einen Übergang
        boolean eingabenEindeutig = true;
        boolean mindEinUebergang = true;
        for (int i = 0; i < zustaende.size(); i++) {
            Zustand z = zustaende.get(i);

            ArrayList<String> eingaben = new ArrayList<>();
            // Passende Übergänge für diesen Zustand
            for (int j = 0; j < uebergaenge.size(); j++) {
                Uebergang u = uebergaenge.get(j);
                if (u.eingangsZustand() == z) {
                    // Übergang passt zu diesem Zustand (äußere for-Schleife)
                    eingaben.add(u.eingabe());
                }
            }

            if (eingaben.isEmpty() && !istEnde(z)) {
                // Zustand ohne Übergänge
                mindEinUebergang = false;
            }

            // Finde Doppelungen
            for (int k = 0; k < eingaben.size(); k++) {
                String eingabe = eingaben.get(k);
                for (int l = k + 1; l < eingaben.size(); l++) {
                    if (eingaben.get(l) == eingabe) {
                        // Doppelung
                        eingabenEindeutig = false;
                        break;
                    }
                }
            }
        }

        return endeHatUebergang && eingabenEindeutig && mindEinUebergang;
    }
}
