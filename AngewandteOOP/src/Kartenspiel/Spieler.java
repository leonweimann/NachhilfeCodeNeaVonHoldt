package Kartenspiel;

import java.util.ArrayList;

/*
* - hand: ArrayList<Karte>
* - ablegen(Karte karte)
* + kannSchlagen(Karte karte): boolean
* + nutzbareKarten(Karte karte): Karte[]
* + legeKarte(Karte zuSchlagen): Karte
* + nehmeKarte(Karte karte)
*/
public class Spieler {
    private ArrayList<Karte> hand;

    private void ablegen(Karte karte) {
        hand.remove(karte);
    }

    /*
     * - Bild muss gleich sein
     * - Wert ist höher
     */
    public Karte[] nutzbareKarten(Karte karte) {
        ArrayList<Karte> nutzbare = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            Karte handKarte = hand.get(i);
            if (karte.bild() == handKarte.bild() && karte.wert() < handKarte.wert()) {
                nutzbare.add(handKarte);
            }
        }
        return (Karte[]) nutzbare.toArray();
    }

    public boolean kannSchlagen(Karte karte) {
        return nutzbareKarten(karte).length > 0;
    }

    /*
     * Wir schlagen immer mit der kleinstmöglichen Karte
     */
    public Karte legeKarte(Karte zuSchlagen) {
        Karte[] nutzbar = nutzbareKarten(zuSchlagen);

        Karte min = nutzbar[0];
        for (int i = 1; i < nutzbar.length; i++) {
            if (nutzbar[i].wert() < min.wert()) {
                min = nutzbar[i];
            }
        }

        ablegen(min); // wenn wir die Karte legen, dann verschwindet sie aus der Hand

        return min;
    }

    public void nehmeKarte(Karte karte) {
        hand.add(karte);
    }
}
