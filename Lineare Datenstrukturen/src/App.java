// Nur, damit der Editor nicht meckert -> Egal
@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) throws Exception {
        WeatherStation ws = new WeatherStation();
    }

    /*
     * Aufgabe 1
     */
    private static void avarageCalculation() {
        // 1. Feld erstellen
        int field[] = new int[10]; // erstelle ein leerer Array / Feld mit 10 Slots

        // 2. Feld mit zufälligen Zahlen füllen
        for (int i = 0; i < field.length; ++i) {
            int randomInt = (int) (1 + (10 - 1) * Math.random()); // zufällige Zahlen zwischen 1 und 10
            field[i] = randomInt; // setze neue zufällige Zahl ins Feld
            System.out.println((i + 1) + ". Zahl = " + field[i]);
        }

        // 3. Mittelwert
        double sum = 0; // Double, damit Division beim average korrekt klappt.
        for (int i = 0; i < field.length; ++i) {
            sum += field[i];
        }
        // Damit average ein korrekter double ist, muss mind. Divident oder Divisor
        // ein double sein (Casting wäre auch okay, aber nur einen jeweils, nicht
        // beide gebündelt).
        double average = sum / field.length;
        System.out.println("Mittelwert der " + field.length + " Zahlen = " + average);
    }

    /*
     * Aufgabe 2
     */
    private static class WeatherStation { // (static nur damit alles in einer Datei)
        // Speichert die heutigen 10 Messwerte zur Temperatur in °C.
        private double measuredTemperature[];

        public WeatherStation() {
            measuredTemperature = new double[10]; // erstelle das leerer Feld mit 10 Plätzen
            fillMeasuredTemperature();
        }

        // Fülle Feld mit den zufälligen Daten.
        private void fillMeasuredTemperature() {
            // Einmal durchs ganze Feld
            for (int i = 0; i < measuredTemperature.length; ++i) {
                // Zufallszahl zwischen 10 und 20 generieren
                double randomDouble = (int) (10 + (20 - 10) * Math.random());
                // Zufallszahl abspeichern / einfügen
                measuredTemperature[i] = randomDouble;
            }
        }

        // Berechnet die kleinste Zahl in unserem Feld und gibt diese zurück.
        private double getMinValue() {
            // Wir merken uns die 'aktuelle' kleinste Zahl.
            // ... Ersten Wert aus dem Feld, nicht 0, sonst findet die Funktion ggf. keine
            // ... kleinere Zahl...
            double currentMinValue = measuredTemperature[0];
            for (int i = 1; i < measuredTemperature.length; ++i) {
                // Nur wenn die 'aktuelle' Zahl (aus der Schleife) kleiner ist, als die, welche
                // wir uns gemerkt haben (currentMinValue)
                if (measuredTemperature[i] < currentMinValue) {
                    // Dann merken wir uns die neue, kleinere Zahl
                    currentMinValue = measuredTemperature[i];
                }
            }
            // Wir sind fertig, also geben wir das Ergebnis zurück
            return currentMinValue;
        }

        // Berechnet den Durchschnittswert des Feldes und gibt diesen zurück.
        private double getAverage() {
            // Summe der Messwerte bestimmen
            double sum = 0;
            for (int i = 0; i < measuredTemperature.length; ++i) {
                sum += measuredTemperature[i];
            }
            // Mittelwert betimmen
            double average = sum / measuredTemperature.length;
            return average;
        }
    }
}

// { 1 , 4 , 8 , 2 , 3 }