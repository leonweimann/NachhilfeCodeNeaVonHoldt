package oop;

public class Münze {
    private int wert; // in ct

    public Münze(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }

    public String toString() {
        return "Münze(" + wert + ")";
    }
}