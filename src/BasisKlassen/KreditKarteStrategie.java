package BasisKlassen;

public class KreditKarteStrategie implements Bezahlstrategie {

    final String bezeichnung = "Kreditkarte";

    @Override
    public double pay(double betrag) {
        System.out.println("Der Betrag " + betrag + " Euro wird mit der Bezahlstrategie Kreditkarte bezahlt.");
        return 0;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }


}
