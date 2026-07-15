package Abi2024;

public class Regioteilnehmerbaum {
    private int anzahlAnmeldungen = 0;
    private Baum regiobaum;

    public void anzahlAnmeldungenErhöhen(String teilnehmerEmail) {
        // eMail nicht im Baum? -> Einfügen
        if (!istInBaum(teilnehmerEmail))
            teilnehmerEinfügen(teilnehmerEmail);

        // Anzahl erhöhen
        anzahlAnmeldungen++;
    }

    public boolean istInBaum(String teilnehmerEmail) {
        Baum wurzel = regiobaum;
        while (wurzel != null) {
            Baum links = wurzel.linkerTeilbaum();
            Baum rechts = wurzel.rechterTeilbaum();

            if (wurzel.inhalt().equals(teilnehmerEmail))
                return true;
            else if (links != null && links.inhalt().compareTo(teilnehmerEmail) > 0)
                wurzel = links;
            else
                wurzel = rechts;
        }
        return false;
    }

    public void teilnehmerEinfügen(String teilnehmerEmail) {

    }
}
