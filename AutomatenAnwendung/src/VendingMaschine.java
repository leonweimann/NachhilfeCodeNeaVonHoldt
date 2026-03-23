public class VendingMaschine {
    /**
     * zustände = [q0, q1, q2, q3]
     * start = q0
     * ende = q3
     * übergänge = [
     * (q0->q1, bestätigen),
     * (q1->q2, genug €),
     * (q1->q1, nicht genug €),
     * (q2->q3, Produkt entnommen)
     * ]
     */
    private Automat automat;

    private String[] produkte;
    private int aktuellesProdukt = -1;

    public VendingMaschine(String[] produkte) {
        Zustand q0 = new Zustand("Eingabe von einem Produkt (Nummer)");
        Zustand q1 = new Zustand("Geld einwerfen");
        Zustand q2 = new Zustand("Produkt ausgeben und Rückgeld");
        Zustand q3 = new Zustand("Dankeschön");

        Zustand zustaende[] = {q0, q1, q2, q3};
        automat = new Automat(zustaende, q0, q1);

        automat.addUebergang(q0, q1, "Artikel bestätigen");
        automat.addUebergang(q1, q1, "nicht genug €");
        automat.addUebergang(q1, q2, "genug €");
        automat.addUebergang(q2, q3, "Produkt wurde entnommen");

        this.produkte = produkte;
    }

    public Zustand aktuellerZustand() {
        return automat.aktuell();
    }

    public Zustand naechsterZustand(String eingabe) {
        return automat.naechsterZustand(eingabe);
    }

    public int aktuellesProdukt() {
        return aktuellesProdukt;
    }

    public void waehleProdukt(int nummer) {
        if (istNummer(nummer))
            aktuellesProdukt = nummer;
        else
            aktuellesProdukt = -1;
    }

    public double produktPreis(int nummer) {
        if (!istNummer(nummer)) return -1;
        return 0.5 * nummer * nummer + 1;
    }

    public boolean istNummer(int nummer) {
        if (nummer >= 0 && nummer < produkte.length)
            return true;
        return false;
    }
}
