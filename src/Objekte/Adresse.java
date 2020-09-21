package Objekte;

import java.io.Serializable;

/**
 *
 * @author Sergey Orlov
 * @version 1.0
 *
 * Der Typ Adresse.
 */
public class Adresse implements Serializable {

    private String strassenName;
    private String hausNummer;
    private String stadt;
    private String plz;

    /**
     * Instantiates a new Adresse.
     */
    public Adresse() {
    }

    /**
     * Konstruktor der Klasse Adresse
     * Instanziiert ein neues Objekt der Klasse Adresse.
     *
     * @param strassenName der straßen name
     * @param hausNummer  die haus nummer
     * @param stadt       die stadt
     * @param plz         die plz
     */
    public Adresse(String strassenName, String hausNummer, String stadt, String plz) {
        this.strassenName = strassenName;
        this.hausNummer = hausNummer;
        this.stadt = stadt;
        this.plz = plz;
    }

    /**
     * Get straßen name string.
     *
     * @return string Straßenname
     */
    public String getStrassenName() {
        return strassenName;
    }

    /**
     * Set straßenName.
     *
     * @param strassenName den Straßennamen
     */
    public void setStrassenName(String strassenName) {
        this.strassenName = strassenName;
    }

    /**
     * Gets hausNummer.
     *
     * @return die Hausnummer
     */
    public String getHausNummer() {
        return hausNummer;
    }

    /**
     * Sets haus nummer.
     *
     * @param hausNummer die Hausnummer
     */
    public void setHausNummer(String hausNummer) {
        this.hausNummer = hausNummer;
    }

    /**
     * Gets stadt.
     *
     * @return die stadt
     */
    public String getStadt() {
        return stadt;
    }

    /**
     * Sets stadt.
     *
     * @param stadt die stadt
     */
    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    /**
     * Gets plz.
     *
     * @return die plz
     */
    public String getPlz() {
        return plz;
    }

    /**
     * Sets plz.
     *
     * @param plz die plz
     */
    public void setPlz(String plz) {
        this.plz = plz;
    }

    /**
     * String liefert String mit allen Informationen über den Kunden.
     *
     * @return einen string mit allen Informationen über den Kunden
     */
    @Override
    /*public String toString() {
        return String.format("Strasse: %s %s PLZ: %s Stadt: %s", getStrassenName(), getHausNummer(), getPlz(), getStadt());
    }*/
    public String toString() {
        return getStrassenName() + " " + getHausNummer() +", " + getPlz() + " " + getStadt();
    }
}
