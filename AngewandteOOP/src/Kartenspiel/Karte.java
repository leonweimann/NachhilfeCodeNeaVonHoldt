package Kartenspiel;

/*
* Karte:
* - wert: int (0 - 51)
* + wert: int (2-14)
* + bild: int (symbol-nummer (1-4))
*/
public class Karte {
    private int wert;

    public Karte(int wert) {
        this.wert = wert;
    }

    public int wert() {
        return wert % 13 + 1;
    }

    public int bild() {
        return wert / 13 + 1;
    }
}