package Finanzen;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Buchhaltung implements Observer {

    private static Buchhaltung refExemplar;

    private ArrayList<Zahlung> zahlungen = new ArrayList<>();

    private Buchhaltung(){}

    public static Buchhaltung getInstance () {
        if (refExemplar == null) {
            refExemplar = new Buchhaltung ();
        }
        return refExemplar;
    }

    public ArrayList<Zahlung> getZahlungen() {
        return zahlungen;
    }



    @Override
    public void update(Observable o, Object zahlung) {
        zahlungen.add((Zahlung) zahlung);
    }
}
