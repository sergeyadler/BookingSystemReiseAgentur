package Objekte;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

/**
 * The type Flugreservierung.
 *
 * @author Sergey Orlov
 * @version 1.0
 */
public class Flugreservierung extends Reservierungen implements Serializable {

    private String abflughafen;
    private String zielflughafen;
    private String flugNummer;



    /**
     * Instantiates a new Flugreservierung.
     *
     * @param datum         the datum
     * @param summe         the summe
     * @param abflughafen   the abflughafen
     * @param zielflughafen the zielflughafen
     * @param flugNummer    the flug nummer
     */
    public Flugreservierung(LocalDate datum, double summe, String abflughafen, String zielflughafen, String flugNummer, Kunde kunde) {
        super(datum, summe, kunde);
        this.abflughafen = abflughafen;
        this.zielflughafen = zielflughafen;
        this.flugNummer = flugNummer;
    }

    /**
     * Instantiates a new Flugreservierung.
     */
    public Flugreservierung() {
    }

    /**
     * Gets abflughafen.
     *
     * @return the abflughafen
     */
    public String getAbflughafen() {
        return abflughafen;
    }

    /**
     * Sets abflughafen.
     *
     * @param abflughafen the abflughafen
     */
    public void setAbflughafen(String abflughafen) {
        this.abflughafen = abflughafen;
    }

    /**
     * Gets zielflughafen.
     *
     * @return the zielflughafen
     */
    public String getZielflughafen() {
        return zielflughafen;
    }

    /**
     * Sets zielflughafen.
     *
     * @param zielflughafen the zielflughafen
     */
    public void setZielflughafen(String zielflughafen) {
        this.zielflughafen = zielflughafen;
    }

    /**
     * Gets flug nummer.
     *
     * @return the flug nummer
     */
    public String getFlugNummer() {
        return flugNummer;
    }

    /**
     * Sets flug nummer.
     *
     * @param flugNummer the flug nummer
     */
    public void setFlugNummer(String flugNummer) {
        this.flugNummer = flugNummer;
    }


    /**
     *
     * @override toString()
     * @return String
     */
    @Override
    /*public String toString() {
        return super.toString() + "\n\tAbflughafen: " + abflughafen + "\n\tZielflughafen: " + zielflughafen + "\n\tFlugNummer: " + flugNummer;
    }*/
    public String toString() {
        return super.toString() + ", Flugnummer " + flugNummer;
    }
}
