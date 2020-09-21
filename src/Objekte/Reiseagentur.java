package Objekte;

import java.io.Serializable;
import java.util.*;

/**
 * The type Reiseagentur.
 *
 * @authors0571777 Sergey Orlov
 * @version 1.0
 */
public class Reiseagentur implements Serializable {

    private String name;
    private String identifikationsNummer;
    private Adresse adresse;
    // private Kunde[] kunden = new Kunde[100];
    private ArrayList<Kunde> kunden = new ArrayList<>();
    private int kundenZaehler = 0;
    // private static HashMap<String,Integer> overviewPaymentMethods = new HashMap();


    /**
     * Find customers array list.
     *
     * @param name the name
     * @return the array list
     */
    public ArrayList<Kunde> findCustomers(String name){
        ArrayList<Kunde> kunden = new ArrayList<>();
        for (Kunde kunde: getKunden()){
            if ((kunde.getVorName().toLowerCase() + kunde.getNachName().toLowerCase()).contains(name.toLowerCase()))
                kunden.add(kunde);
        }
        return kunden;
    }

    /**
     * Konstruktor der Klasse Reiseagentur.
     * Instanziiert eine neue Reiseagentur.
     *
     * @param name                  der name
     * @param identifikationsNummer die identifikations nummer
     * @param adresse               die adresse
     */
    public Reiseagentur(String name, String identifikationsNummer, Adresse adresse) {
        this.name = name;
        this.identifikationsNummer = identifikationsNummer;
        this.adresse = adresse;
    }

    /**
     * Gets name.
     *
     * @return name den Namen
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name sets name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets identifikations nummer.
     *
     * @return die identifikations nummer
     */
    public String getIdentifikationsNummer() {
        return identifikationsNummer;
    }

    /**
     * Sets identifikations nummer.
     *
     * @param identifikationsNummer die identifikations nummer
     */
    public void setIdentifikationsNummer(String identifikationsNummer) {
        this.identifikationsNummer = identifikationsNummer;
    }

    /**
     * Gets adresse.
     *
     * @return die adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse die adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    /**
     * Sets kunde im Array, dann springt Zähler hoch, damit nächster kunde an nächster Stelle im Array steht.
     *
     * @param customer der kunde
     * @return the boolean
     * @throws IndexOutOfBoundsException wirft exception falls mehr als 100 Kunden eingetragen werden und somit die Länge des Arrays überschritten
     */
    public boolean addKunde(Kunde customer) {
        kunden.add(customer);
        return true;
    }

    /**
     * Sorted customers array list.
     *
     * @return the array list
     */
    public ArrayList<Kunde> sortedCustomers(){
        ArrayList<Kunde> sorted = new ArrayList<>();
        sorted = kunden;
        Collections.sort(sorted);
        return sorted;
    }


    /**
     * Gets kunde mit der übergebenen Kundennummer.
     *
     * @param kundenNummer die kunden nummer
     * @return den kunden
     */
    public Kunde getSingleKunde(String kundenNummer){

        for(Kunde kunde: kunden){
            if(kunde.getKundenNummer().equals(kundenNummer))
                return kunde;
        }

   /*     for (int i = 0; i < kunden.length; i++){
            Kunde kunde = kunden[i];
            if (kunde != null){
                if (kunde.getKundenNummer().equals(kundenNummer)) {
                    return kunde;
                }
            }
        }*/
        return null;
    }

    /**
     * Get kunden array list.
     *
     * @return the array list
     */
    public ArrayList<Kunde> getKunden(){
        return kunden;
    }

    /**
     * Printed alle Informationen der Reiseagentur und der dazugehörigen Kunden.
     */
    public void print(){
        System.out.println((String.format("Name: %s \nIdentifikationsnummer: %s \nAdresse %s", getName(), getIdentifikationsNummer(), getAdresse().toString())));
        System.out.println("Kunden: ");
        int i = 1;
        for (Kunde kunde: kunden){
            if (kunde != null) {
                System.out.println(i + ".\n" + kunde.toString());
                System.out.println("-------------------------------");
                i++;
            }
        }

    }
}
