package Finanzen;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Auditing implements Observer {

    private static Auditing refExemplar;

    private ArrayList<Zahlung> bezahlungen = new ArrayList<>();

    private Auditing(){}

    public static Auditing getInstance () {
        if (refExemplar == null) {
            refExemplar = new Auditing ();
        }
        return refExemplar;
    }


    public ArrayList<Zahlung> getBezahlungen() {
        return bezahlungen;
    }

    public void addBezahlung(Zahlung zahlung) {
        bezahlungen.add(zahlung);
    }

    public void update(Zahlung zahlung){
        if (zahlung.getBetrag() > (double) 1000)
            addBezahlung(zahlung);
    }

    @Override
    public void update(Observable o, Object obj) {
        Zahlung zahlung = (Zahlung) obj;
        if (zahlung.getBetrag() > 1000)
            bezahlungen.add(zahlung);

    }
}


