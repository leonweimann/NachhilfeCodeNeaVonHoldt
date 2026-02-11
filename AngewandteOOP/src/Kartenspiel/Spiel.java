package Kartenspiel;

import java.util.Stack;
import java.util.Collections;

public class Spiel {
    private Spieler[] spieler;
    private Stack<Karte> stapel = new Stack<>();

    /*
     * Max. 4 Spieler, sonst zu wenig Karten
     */
    public Spiel(int anzahlSpieler) {
        spieler = new Spieler[anzahlSpieler];
        befülleStack(alleKarten());
        mische();
    }

    public Karte[] alleKarten() {
        Karte[] karten = new Karte[52];
        for (int i = 0; i < karten.length; i++) {
            karten[i] = new Karte(i);
        }
        return karten;
    }

    public void befülleStack(Karte[] karten) {
        for (int i = 0; i < karten.length; i++) {
            stapel.push(karten[i]);
        }
    }

    public void mische() {
        Collections.shuffle(stapel);
    }

    /*
     * Spieler haben am Anfang 8 Karten
     */
    public void verteileKarten() {
        final int kartenJeSpieler = 8;
        for (int i = 0; i < kartenJeSpieler; i++) {
            for (int j = 0; j < spieler.length; j++) {
                Karte karte = stapel.pop();
                spieler[i].nehmeKarte(karte);
            }
        }
    }
}
