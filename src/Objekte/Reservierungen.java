package Objekte;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

/**
 * The type Reservierungen.
 *
 * @author s0571777 Sergey Orlov
 * @version 1.0
 */
public abstract class Reservierungen implements Comparable<Reservierungen>, Serializable {

    private static int anzahlReservierungen = 1;
    private String reservierungsNummer = "X00" + anzahlReservierungen;
    private LocalDate datum;
    private double summe;
    private String kundenNummer;
    private Kunde kunde;

/*    @Override
    public int compare(Reservierungen o1, Reservierungen o2) {
        return o1.getKunde().compareTo(o2.getKunde());
    }*/

    /**
     *
     * @pverrides comparteTo()
     * @return compared Kunde
     */
    @Override
    public int compareTo(Reservierungen o) {
        Reservierungen other = (Reservierungen) o;
        return (this.datum).compareTo(other.datum) + this.getKunde().compareTo(other.getKunde());
    }

    /**
     * Gets kunde.
     *
     * @return the kunde
     */
    public Kunde getKunde() {
        return kunde;
    }

    /**
     * Sets kunde.
     *
     * @param kunde the kunde
     */
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    /**
     * Instantiates a new Reservierungen.
     *
     * @param datum the datum
     * @param summe the summe
     * @param kunde the kunde
     */
    public Reservierungen(LocalDate datum, double summe, Kunde kunde) {
        this.kunde = kunde;
        this.datum = datum;
        this.summe = summe;
        anzahlReservierungen++;
    }

    /**
     * Instantiates a new Reservierungen.
     */
    public Reservierungen() {
    }

    /**
     * Gets kunden nummer.
     *
     * @return the kunden nummer
     */
    public String getKundenNummer() {
        return kundenNummer;
    }

    /**
     * Sets kunden nummer.
     *
     * @param kundenNummer the kunden nummer
     */
    public void setKundenNummer(String kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    /**
     * Gets reservierungs nummer.
     *
     * @return the reservierungs nummer
     */
    public String getReservierungsNummer() {
        return reservierungsNummer;
    }


    /**
     * Gets datum.
     *
     * @return the datum
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * Sets datum.
     *
     * @param datum the datum
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    /**
     * Gets summe.
     *
     * @return the summe
     */
    public double getSumme() {
        return summe;
    }

    /**
     * Sets summe.
     *
     * @param summe the summe
     */
    public void setSumme(double summe) {
        this.summe = summe;
    }


    /**
     * overrides toString()
     *
     * @return String
     */

    @Override
    /*public String toString(){
        return "\n\tReservierungsnummer: " + reservierungsNummer + "\n\tDatum " + datum + "\n\tSumme: " + summe + "€";
    }*/
    public String toString(){
        return reservierungsNummer + ", " + datum;
    }
}

