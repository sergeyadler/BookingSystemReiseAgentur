package BasisKlassen;

public class RechnungStrategie implements Bezahlstrategie {

    final String bezeichnung = "Rechnung";

    @Override
    public double pay(double betrag) {
        System.out.println("Der Betrag " + betrag + " Euro wird mit der Bezahlstrategie Rechnung bezahlt.");
        return 0;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }
}

