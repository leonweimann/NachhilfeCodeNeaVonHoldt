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

    public VendingMaschine() {
        Zustand q0 = new Zustand("Eingabe von einem Produkt (Nummer)");
        Zustand q1 = new Zustand("Geld einwerfen");
        Zustand q2 = new Zustand("Produkt ausgeben und Rückgeld");
        Zustand q3 = new Zustand("Dankeschön");

        Zustand zustände[] = {q0, q1, q2, q3};
        automat = new Automat(zustände, q0, q1);

        automat.addÜbergang(q0, q1, "Artikel bestätigen");
        automat.addÜbergang(q1, q1, "nicht genug €");
        automat.addÜbergang(q1, q2, "genug €");
        // TODO ...
    }
}
