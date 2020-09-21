package Finanzen;

import BasisKlassen.Bezahlstrategie;

import java.util.ArrayList;
import java.util.Observable;

public class Kasse extends Observable {

    private static Kasse refExemplar;


    private Kasse(){}

    private Bezahlstrategie bezahlstrategie;

    public void setBezahlstrategie(Bezahlstrategie bezahlstrategie) {
        this.bezahlstrategie = bezahlstrategie;
    }

    public static Kasse getInstance () {
        if (refExemplar == null) {
            refExemplar = new Kasse ();
        }
        return refExemplar;
    }

    public boolean bezahlen(double betrag){
        //new Zahlung(betrag,bezahlstrategie).notifyObservers(this);
        Zahlung zahlung = new Zahlung(betrag,bezahlstrategie);
        Buchhaltung.getInstance().update(this, zahlung);
        Auditing.getInstance().update(this, zahlung);
        bezahlstrategie.pay(betrag);
        return true;
    }

    public Bezahlstrategie getBezahlstrategie() {
        return bezahlstrategie;
    }
}
