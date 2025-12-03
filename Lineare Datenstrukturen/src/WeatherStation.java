public final class WeatherStation {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        ws.printAll();
    }

    // Speichert beliebige 10 Messwerte wie bspw. Temperatur in °C,
    // Windgeschwindigkeit, ...
    // 2D-Feld: 1. Stelle = Welcher Messwert; 2. Stelle = Wert des Messwertes
    private double measuredData[][];

    public WeatherStation() {
        measuredData = new double[10][10]; // erstelle das leere Feld mit 10x10 Plätzen
        fillMeasuredValues();
    }

    // Fülle Feld mit den zufälligen Daten.
    public void fillMeasuredValues() {
        // Einmal für jede Art von Messwert
        for (int i = 0; i < measuredData.length; ++i) {
            // Einmal durchs ganze Feld
            for (int j = 0; j < measuredData[i].length; ++j) {
                // Zufallszahl zwischen 10 und 20 generieren
                double randomDouble = (int) (5 + (101 - 5) * Math.random());
                // Zufallszahl abspeichern / einfügen
                measuredData[i][j] = randomDouble;
            }
        }
    }

    // Berechnet die kleinste Zahl im angegebenen Feld und gibt diese zurück.
    // Der Parameter i ist das Feld, welches durchsucht werden soll.
    public double getMinValue(int i) {
        // Wir merken uns die 'aktuelle' kleinste Zahl.
        // ... Ersten Wert aus dem Feld, nicht 0, sonst findet die Funktion ggf. keine
        // ... kleinere Zahl...
        double currentMinValue = measuredData[i][0];
        for (int j = 1; j < measuredData[i].length; ++j) {
            // Nur wenn die 'aktuelle' Zahl (aus der Schleife) kleiner ist, als die, welche
            // wir uns gemerkt haben (currentMinValue)
            if (measuredData[i][j] < currentMinValue) {
                // Dann merken wir uns die neue, kleinere Zahl
                currentMinValue = measuredData[i][j];
            }
        }
        // Wir sind fertig, also geben wir das Ergebnis zurück
        return currentMinValue;
    }

    public double getMaxValue(int i) {
        double currentMaxValue = measuredData[i][0];
        for (int j = 1; j < measuredData[i].length; ++j) {
            if (measuredData[i][j] > currentMaxValue) {
                currentMaxValue = measuredData[i][j];
            }
        }
        return currentMaxValue;
    }

    // Berechnet den Durchschnittswert eines Feldes und gibt diesen zurück.
    public double getAverage(int i) {
        // Summe der Messwerte bestimmen
        double sum = 0;
        for (int j = 0; j < measuredData[i].length; ++j) {
            sum += measuredData[i][j];
        }
        // Mittelwert betimmen
        double average = sum / measuredData[i].length;
        return average;
    }

    public void printOneValueRow(int i) {
        // i+1 da i von 0 zählt, wir wollen aber ab 1 zeigen.
        System.out.println();
        System.out.print("Daten des Messwertes " + (i + 1) + ": ");
        for (int j = 0; j < measuredData[i].length; ++j) {
            if (j == 0) {
                System.out.print(" ");
            } else {
                System.out.print(" / ");
            }
            System.out.print(measuredData[i][j]);
        }
        System.out.println();

        System.out.println("Durchschnitt des " + (i + 1) + ". Messwertes: " + getAverage(i));

        double sum = 0;
        for (int j = 0; j < measuredData[i].length; ++j) {
            sum += measuredData[i][j];
        }
        System.out.println("Summe der Messdaten des " + (i + 1) + ". Messwertes: " + sum);

        System.out.println("Kleinster Messwert des " + (i + 1) + ". Messwertes: " + getMinValue(i));
        System.out.println("Größter Messwert des " + (i + 1) + ". Messwertes: " + getMaxValue(i));
    }

    public void printAll() {
        for (int i = 0; i < measuredData.length; ++i) {
            printOneValueRow(i);
        }
    }
}