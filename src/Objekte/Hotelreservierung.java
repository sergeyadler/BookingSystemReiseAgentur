package Objekte;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * The type Hotelreservierung.
 *
 * @author s0571777 Sergey Orlov
 * @version 1.0
 */
public class Hotelreservierung extends Reservierungen implements Serializable {

    private String hotelName;
    private int reiseDauer;

    /**
     * Instantiates a new Hotelreservierung.
     *
     * @param datum      the datum
     * @param summe      the summe
     * @param hotelName  the hotel name
     * @param reiseDauer the reise dauer
     */
    public Hotelreservierung(LocalDate datum, double summe, String hotelName, int reiseDauer, Kunde kunde) {
        super(datum, summe, kunde);
        this.hotelName = hotelName;
        this.reiseDauer = reiseDauer;
    }

    /**
     * Gets hotel name.
     *
     * @return the hotel name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets hotel name.
     *
     * @param hotelName the hotel name
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Gets reise dauer.
     *
     * @return the reise dauer
     */
    public int getReiseDauer() {
        return reiseDauer;
    }

    /**
     * Sets reise dauer.
     *
     * @param reiseDauer the reise dauer
     */
    public void setReiseDauer(int reiseDauer) {
        this.reiseDauer = reiseDauer;
    }

    /**
     * Instantiates a new Hotelreservierung.
     */
    public Hotelreservierung() {
    }


    /**
     * overrides toString()
     *
     * @return String
     */

    @Override
   /* public String toString(){
        return super.toString() + "\n\tHotelname: " + hotelName + "\n\tReisedauer: " + reiseDauer + "\n\tNächte";
    }*/
    public String toString(){
        return super.toString()+ ", bei " + hotelName;
    }
}
