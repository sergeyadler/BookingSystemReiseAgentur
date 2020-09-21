package Objekte;

import BasisKlassen.Anrede;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The type Privatkunde.
 *
 * @author s0571777 Sergey Orlov
 * @version 1.0
 */
public class Privatkunde extends Kunde implements Serializable {
    /**
     * Konstruktor der Klasse Kunde
     * instanziiert einen neuen Kunden.
     *
     * @param vorName       Vorname
     * @param nachName      Nachname
     * @param geburtsDatum  Geburtsdatum
     * @param telefonNummer Telefonnummer
     * @param eMailAdresse  E-Mail-Adresse
     */
    public Privatkunde(String vorName, String nachName, LocalDate geburtsDatum, String telefonNummer, String eMailAdresse) {
        super(vorName, nachName, geburtsDatum, telefonNummer, eMailAdresse);
    }

    /**
     * overrides getName()
     *
     * @return String name
     */

    @Override
    public String getName() {
        return getVorName() + " " + getNachName();
    }

    /**
     * Instantiates a new Privatkunde.
     *
     * @param anrede        the anrede
     * @param vorName       the vor name
     * @param nachName      the nach name
     * @param geburtsDatum  the geburts datum
     * @param telefonNummer the telefon nummer
     * @param eMailAdresse  the e mail adresse
     */
    public Privatkunde(Anrede anrede, String vorName, String nachName, LocalDate geburtsDatum, String telefonNummer, String eMailAdresse) {
        super(anrede, vorName, nachName, geburtsDatum, telefonNummer, eMailAdresse);
    }

}
