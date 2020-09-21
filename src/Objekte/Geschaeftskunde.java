package Objekte;

import BasisKlassen.Anrede;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The type Geschaeftskunde.
 *
 * @author s0571777 Sergey Orlov
 * @version 1.0
 */
public class Geschaeftskunde extends Kunde implements Serializable {

    private String firmenName;

    /**
     * Gets firmen name.
     *
     * @return the firmen name
     */
    public String getFirmenName() {
        return firmenName;
    }

    /**
     * Sets firmen name.
     *
     * @param firmenName the firmen name
     */
    public void setFirmenName(String firmenName) {
        this.firmenName = firmenName;
    }


    /**
     * Konstruktor der Klasse Kunde
     * instanziiert einen neuen Kunden.
     *
     * @param vorName       Vorname
     * @param nachName      Nachname
     * @param geburtsDatum  Geburtsdatum
     * @param telefonNummer Telefonnummer
     * @param eMailAdresse  E-Mail-Adresse
     * @param firmenName    the firmen name
     */
    public Geschaeftskunde(String vorName, String nachName, LocalDate geburtsDatum, String telefonNummer, String eMailAdresse, String firmenName) {
        super(vorName, nachName, geburtsDatum, telefonNummer, eMailAdresse);
        this.firmenName = firmenName;
    }

    /**
     * Instantiates a new Geschaeftskunde.
     *
     * @param anrede        the anrede
     * @param vorName       the vor name
     * @param nachName      the nach name
     * @param geburtsDatum  the geburts datum
     * @param telefonNummer the telefon nummer
     * @param eMailAdresse  the e mail adresse
     * @param firmenName    the firmen name
     */
    public Geschaeftskunde(Anrede anrede, String vorName, String nachName, LocalDate geburtsDatum, String telefonNummer, String eMailAdresse, String firmenName) {
        super(anrede, vorName, nachName, geburtsDatum, telefonNummer, eMailAdresse);
        this.firmenName = firmenName;
    }


    /**
     * overrides getName()
     *
     * @return String name
     */
    @Override
    public String getName(){
        return getVorName() + " " + getNachName() + " - " + getFirmenName();
    }


}
