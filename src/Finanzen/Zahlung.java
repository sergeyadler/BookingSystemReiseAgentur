package Finanzen;

import BasisKlassen.Bezahlstrategie;

import java.util.Observable;

public class Zahlung extends Observable {

    private double betrag;
    private Bezahlstrategie bezahlmethode;


    public Zahlung(double betrag, Bezahlstrategie bezahlmethode) {
        this.betrag = betrag;
        this.bezahlmethode = bezahlmethode;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public Bezahlstrategie getBezahlmethode() {
        return bezahlmethode;
    }

    public void setBezahlmethode(Bezahlstrategie bezahlmethode) {
        this.bezahlmethode = bezahlmethode;
    }

    @Override
    public String toString() {
        return "Betrag: " + betrag;
    }
}
