public class Haustier {
    // --- Eigenschaften / Attribute ---

    private String name;
    private int alter;
    private FellFarbe fellFarbe;

    // --- Konstruktor ---

    public Haustier(String name, int alter, FellFarbe fellFarbe) {
        this.name = name; // 'this.' sagt java, dass das Attribut gemeint ist
        this.alter = alter;
        this.fellFarbe = fellFarbe;
    }

    // --- Methoden / Fähigkeiten ---

    public void laufen() {

    }

    public void sitzen() {

    }

    public void altern() {
        alter++;
    }

    public String getFellFarbe() {
        return fellFarbe.getFarbe();
    }
}
