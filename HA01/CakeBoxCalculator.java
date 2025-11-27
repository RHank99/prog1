import java.util.Scanner;

class CakeBoxCalculator {
    public static void main(String[] args) {
        // Eingabeaufforderung: Anzahl kleine und große Boxen und Kuchenstücke einlesen

        Scanner consoleInput = new Scanner(System.in);

        // Einlesen der Anzahl
        System.out.println("Geben Sie die Anzahl der verfügbaren kleinen Boxen ein:");
        int availableSmallBoxes = consoleInput.nextInt();
        System.out.println("Geben Sie die Anzahl der verfügbaren großen Boxen ein:");
        int availableBigBoxes = consoleInput.nextInt();
        System.out.println("Geben Sie die Anzahl der gewünschten Kuchenstücke ein:");
        int orderQuantity = consoleInput.nextInt();

        // Variablen: großeBox = 6, kleineBox = 1
        int großeBox = 6;
        int kleineBox = 1;

        // Rechnung: Anzahl möglicher Kuchen insgesamt: Anzahl groß * großeBox + Anzahl
        // klein * kleineBox
        int possibleCakes = availableBigBoxes * großeBox + availableSmallBoxes * kleineBox;

        // variablen: großeBoxAusgabe, kleineBoxAusgabe;
        int großeBoxAusgabe;
        int kleineBoxAusgabe;

        // falls Anzahl möglicher Kuchen kleiner Anzahl gewünschter Kuchen --> Ausgabe:
        // geht nicht
        if (possibleCakes < orderQuantity) {
            System.out.println("Bestellung nicht möglich");
        }

        // Rechnung: Teile gewünschte Anzahl durch große Box --> nötigeBoxGross
        großeBoxAusgabe = orderQuantity % availableBigBoxes;

        // falls nötigeBoxGross > AnzahlGrosseBox
        // nötigeBoxGross = AnzahlGrosseBox
        if (großeBoxAusgabe > availableBigBoxes) {
            großeBoxAusgabe = availableBigBoxes;
        }

        // Rechnung: nötigeKleineBox = gewünschte Anzahl - grosseBox * nötigeBoxGross
        kleineBoxAusgabe = orderQuantity - großeBox * großeBoxAusgabe;

        // Falls AnzahlKleineBox < nötigeKleineBox --> Ausgabe geht nicht
        if (availableSmallBoxes < kleineBoxAusgabe) {
            System.out.println("Ausgabe nicht möglich");
        }
        // ansonst
        // Ausgabe: nötigeBoxGross + nötigeKleineBox
        System.out.println("Benötigte große Boxen:" + großeBoxAusgabe + ", benötigte kleine Boxen:" + kleineBoxAusgabe);
    }
}