package Objekte;

import BasisKlassen.Anrede;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * The type Kunde.
 *
 * @author ss0571777 Sergey Orlov
 * @version 1.0
 */
public abstract class Kunde implements Comparable, Serializable {

    private static int anzahlKunden = 1;
    private String kundenNummer = "C00" + anzahlKunden;
    private Anrede anrede;
    private String vorName;
    private String nachName;
    private LocalDate geburtsDatum;
    private String telefonNummer;
    private Adresse adresse;
    private String eMailAdresse;
    private ArrayList<Reservierungen> reservierungen = new ArrayList<>();
    private static HashMap<LocalDate, Set<Reservierungen>> reservationIndex = new HashMap<>();
    private static ArrayList<Reservierungen> allReservations = new ArrayList<>();

    /**
     * Gets reservation index.
     *
     * @return the reservation index
     */
    public static HashMap<LocalDate, Set<Reservierungen>> getReservationIndex() {
        return reservationIndex;
    }



    /**
     * Update index.
     *
     * @param reservierung the reservierung
     */
    public void updateIndex(Reservierungen reservierung){
        LocalDate key = reservierung.getDatum();
        Set<Reservierungen> tagesReservierung = reservationIndex.get(key);
        if (tagesReservierung == null)
            tagesReservierung = new TreeSet<Reservierungen>();
        tagesReservierung.add(reservierung);
        reservationIndex.put(key, tagesReservierung);
        sortIndex();
    }

    /**
     * Sorts index for reservatins
     */
    public static void sortIndex(){
        HashMap<LocalDate, Set<Reservierungen>> unsortMap = reservationIndex;
        List<Map.Entry<LocalDate, Set<Reservierungen>>> list = new ArrayList<>(unsortMap.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        Map<LocalDate, Set<Reservierungen>> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<LocalDate, Set<Reservierungen>> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        reservationIndex = (HashMap<LocalDate, Set<Reservierungen>>) sortedMap;
    }

    /**
     * Index to string string.
     *
     * @return the string
     */
    public static String indexToString(){
        String string = "";
        for (LocalDate key: reservationIndex.keySet()){
            string += "\n\n" + key;
            for (Reservierungen value: reservationIndex.get(key)){
                string += "\nKunde: " + value.getKunde().getName() + value.toString();
            }
        }
        return string;
    }

    /**
     * Gets all reservations.
     *
     * @return the all reservations
     */
    public static ArrayList<Reservierungen> getAllReservations() {
        return allReservations;
    }


    /**
     * Add reservierung.
     *
     * @param reservierung the reservierung
     */
    public void addReservierung(Reservierungen reservierung) {
        this.reservierungen.add(reservierung);
        allReservations.add(reservierung);
        updateIndex(reservierung);
    }


    /**
     * Konstruktor der Klasse Kunde
     * instanziiert einen neuen Kunden.
     *
     * @param anrede        anrede
     * @param vorName       Vorname
     * @param nachName      Nachname
     * @param geburtsDatum  Geburtsdatum
     * @param telefonNummer Telefonnummer
     * @param eMailAdresse  E-Mail-Adresse
     */
    public Kunde(Anrede anrede, String vorName, String nachName, LocalDate geburtsDatum, String telefonNummer, String eMailAdresse) {
        this.anrede = anrede;
        this.vorName = vorName;
        this.nachName = nachName;
        this.geburtsDatum = geburtsDatum;
        this.telefonNummer = telefonNummer;
        this.eMailAdresse = eMailAdresse;
        anzahlKunden++;
    }

    /**
     * Instantiates a new Kunde.
     *
     * @param vorName       the vor name
     * @param nachName      the nach name
     * @param geburtsDatum  the geburts datum
     * @param telefonNummer the telefon nummer
     * @param eMailAdresse  the e mail adresse
     */
    public Kunde(String vorName, String nachName, LocalDate geburtsDatum, String telefonNummer, String eMailAdresse){
        this.vorName = vorName;
        this.nachName = nachName;
        this.geburtsDatum = geburtsDatum;
        this.telefonNummer = telefonNummer;
        this.eMailAdresse = eMailAdresse;
        anzahlKunden++;
    }

    /**
     * Get reservierungen reservierungen [ ].
     *
     * @return the ArrayList() reservierungen
     */
    public ArrayList<Reservierungen> getReservierungen() {
        return reservierungen;
    }

    /**
     * String reservierungen string.
     *
     * @return the string
     */
    public String stringReservierungen(){
        String rt = "";
        int i = 0;
        for (Reservierungen reservierung: reservierungen){
            if (reservierung != null) {
                i++;
                rt += i + ". Reservierung:" + reservierung.toString() + "\n";
            }
        }

        return rt;
    }

    /**
     * Add reservierungen.
     *
     * @param reservierung the reservierungen
     */

    /**
     * Gets kundennummer.
     *
     * @return die kundennummer
     */
    public String getKundenNummer() {
        return kundenNummer;
    }


    /**
     * Gets anrede.
     *
     * @return die anrede
     */
    public Anrede getAnrede() {
        return anrede;
    }

    /**
     * Sets anrede.
     *
     * @param anrede Anrede
     */
    public void setAnrede(Anrede anrede) {
        this.anrede = anrede;
    }

    /**
     * Gets vorname.
     *
     * @return den Vornamen
     */
    public String getVorName() {
        return vorName;
    }

    /**
     * Sets vorname.
     *
     * @param vorName den Vornamen
     */
    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    /**
     * Gets nachname.
     *
     * @return den nachnamen
     */
    public String getNachName() {
        return nachName;
    }

    /**
     * Sets nachname.
     *
     * @param nachName den nachnamen
     */
    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    /**
     * Gets geburtsdatum.
     *
     * @return das Geburtsdatum
     */
    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    /**
     * Sets geburtsdatum.
     *
     * @param geburtsDatum das geburtsdatum
     */
    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    /**
     * Gets telefonnummer.
     *
     * @return die telefonnummer
     */
    public String getTelefonNummer() {
        return telefonNummer;
    }

    /**
     * Sets telefonnummer.
     *
     * @param telefonNummer die telefonnummer
     */
    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    /**
     * Get Adressen.
     *
     * @return Adresse adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse the adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets mail adresse.
     *
     * @return die mail adresse
     */
    public String getEMailAdresse() {
        return eMailAdresse;
    }

    /**
     * Sets mail adresse.
     *
     * @param eMailAdresse die E-mailadresse
     */
    public void setEMailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    /**
     *
     * @param o comparable object
     * @return comparteTo
     */
    @Override
    public int compareTo(Object o) {
        Kunde other = (Kunde) o;
        return (this.nachName + this.vorName).compareTo(other.nachName + other.vorName);
    }

    /**
     * toString() override
     *
     * @return String mit allen Informationen über Kunden
     */

    @Override
   /* public String toString(){
        return ("Kundennummer: " + getKundenNummer() + "\nName: " + getAnrede() + " " + getName() + "\n" +
                "Geburtsdatum: " + getGeburtsDatum() + "\n" +
                "Telefonnummer: " + getTelefonNummer() + "\n"  +
                "Email-Adresse: " + getEMailAdresse() + "\n" +
                "Adresse: \n" + getAdresse() + "\n" +
                stringReservierungen());
    }*/
    public String toString(){
        return getVorName() + " " + getNachName();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public abstract String getName();

    public int getAnzahlReservierungen(){
        return reservierungen.size();
    }
}
