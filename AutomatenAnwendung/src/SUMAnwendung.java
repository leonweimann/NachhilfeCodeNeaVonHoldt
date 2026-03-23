import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class SUMAnwendung extends EBAnwendung {
    private Etikett nummernEtikett;
    private Textfeld nummernFeld;
    private Knopf bestaetigenKnopf;
    private Etikett muenzEinwurfEtikett;
    private Knopf muenzEinwurfKnopf50;
    private Knopf muenzEinwurfKnopf100;
    private Knopf muenzEinwurfKnopf200;
    private Etikett muenzEinwurfBetragsEtikett;
    private Etikett vendingAusgangEtikett;

    private VendingMaschine vendingMaschine;

    public SUMAnwendung() {
        String[] produkte = {"Cola", "Fanta", "Snickers", "Twix", "Haribo"};
        vendingMaschine = new VendingMaschine(produkte);

        nummernEtikett = new Etikett(50, 50, 100, 50, "Nummernfeld");
        nummernFeld = new Textfeld(50, 100, 100, 50, "");
        bestaetigenKnopf = new Knopf(50, 150, 100, 50, "Bestätigen", "bestaetigenKnopfGeklickt");

        muenzEinwurfEtikett = new Etikett(50, 250, 150, 50, "Münzeinwurf: ?");
        muenzEinwurfKnopf50 = new Knopf(50, 300, 50, 50, "0.5", "muenzEinwurf50Geklickt");
        muenzEinwurfKnopf50 = new Knopf(150, 300, 50, 50, "1.0", "muenzEinwurf100Geklickt");
        muenzEinwurfKnopf50 = new Knopf(250, 300, 50, 50, "2.0", "muenzEinwurf200Geklickt");
        muenzEinwurfBetragsEtikett = new Etikett(50, 350, 100, 50, "");

        vendingAusgangEtikett = new Etikett(250, 50, 200, 200, "");
        aktualisiereAusgangsEtikett();
    }

    public void bestaetigenKnopfGeklickt() {
        if (vendingMaschine.aktuellerZustand().name() != "Eingabe von einem Produkt (Nummer)")
            return;

        int nummerEingabe = nummernFeld.inhaltAlsGanzeZahl();
        if (vendingMaschine.istNummer(nummerEingabe))
            vendingMaschine.waehleProdukt(nummerEingabe);
        aktualisiereMuenzEtikett();
        vendingMaschine.naechsterZustand("Artikel bestätigen");
        aktualisiereAusgangsEtikett();
    }

    public void muenzEinwurf50Geklickt() {
        if (vendingMaschine.aktuellerZustand().name() != "Geld einwerfen")
            return;

        if (muenzEinwurfBetragsEtikett.inhaltAlsText() != "") {
            double aktuellerBetrag = muenzEinwurfBetragsEtikett.inhaltAlsZahl();
            muenzEinwurfBetragsEtikett.setzeInhalt(aktuellerBetrag + 0.5);
        } else {
            muenzEinwurfBetragsEtikett.setzeInhalt(0.5);
        }
    }

    public void muenzEinwurf100Geklickt() {
        if (vendingMaschine.aktuellerZustand().name() != "Geld einwerfen")
            return;

        if (muenzEinwurfBetragsEtikett.inhaltAlsText() != "") {
            double aktuellerBetrag = muenzEinwurfBetragsEtikett.inhaltAlsZahl();
            muenzEinwurfBetragsEtikett.setzeInhalt(aktuellerBetrag + 1);
        } else {
            muenzEinwurfBetragsEtikett.setzeInhalt(1);
        }
    }

    public void muenzEinwurf200Geklickt() {
        if (vendingMaschine.aktuellerZustand().name() != "Geld einwerfen")
            return;

        if (muenzEinwurfBetragsEtikett.inhaltAlsText() != "") {
            double aktuellerBetrag = muenzEinwurfBetragsEtikett.inhaltAlsZahl();
            muenzEinwurfBetragsEtikett.setzeInhalt(aktuellerBetrag + 2);
        } else {
            muenzEinwurfBetragsEtikett.setzeInhalt(2);
        }
    }

    public void aktualisiereMuenzEtikett() {
        double preis = vendingMaschine.produktPreis(vendingMaschine.aktuellesProdukt());
        muenzEinwurfEtikett.setzeInhalt("Münzeinwurf: " + preis + "€");
    }

    public void aktualisiereAusgangsEtikett() {
        Zustand z = vendingMaschine.aktuellerZustand();
        vendingAusgangEtikett.setzeInhalt(z.name());
    }
}
