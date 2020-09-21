package BasisKlassen;


public class ECKarteStrategie implements Bezahlstrategie {

    final String bezeichnung = "EC-Karte";

    @Override
    public double pay(double betrag) {
        System.out.println("Der Betrag " + betrag + " Euro wird mit der Bezahlstrategie EC-Karte bezahlt.");
        return 0;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }
}
