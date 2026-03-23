public class Uebergang {
    private Zustand eingangsZustand;
    private Zustand ausgangsZustand;
    private String eingabe;

    public Uebergang(Zustand eingang, Zustand ausgang, String eingabe) {
        this.eingangsZustand = eingang;
        this.ausgangsZustand = ausgang;
        this.eingabe = eingabe;
    }

    public Zustand eingangsZustand() {
        return eingangsZustand;
    }

    public Zustand ausgangsZustand() {
        return ausgangsZustand;
    }

    public String eingabe() {
        return eingabe;
    }
}