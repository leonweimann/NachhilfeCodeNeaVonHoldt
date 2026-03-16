public class Übergang {
    private Zustand eingangsZustand;
    private Zustand ausgangsZustand;
    private String eingabe;

    public Übergang(Zustand eingang, Zustand ausgang, String eingabe) {
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