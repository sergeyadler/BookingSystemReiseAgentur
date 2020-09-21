package User;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import BasisKlassen.*;
import Finanzen.Auditing;
import Finanzen.Buchhaltung;
import Finanzen.Kasse;
import Finanzen.Zahlung;
import GUI.Oberfläche;
import Objekte.*;

import javax.swing.*;


/**
 * The type Starter.
 *
 * @author s0571777 Sergey Orlov
 * @version 1.0
 */
public class Starter implements Serializable {

    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Main Methode des Programms
     *
     * @param args die input arguments
     */
    public static void main(String[] args) {

        Adresse adresseRA = new Adresse("Hauptstrasse", "5a", "Berlin", "10559");
        Adresse adresseK1 = new Adresse("Hermannstrasse", "11", "Berlin", "15698");
        Adresse adresseK2 = new Adresse("Hermannstrasse", "11", "Berlin", "15698");
        Adresse adresseK3 = new Adresse("Oligarchenplatz", "101", "München", "10098");

        //Bezahlmethode bezahlmethode1 = new Bezahlmethode("PayPal", "HHP@gmail.com");
        //Bezahlmethode bezahlmethode2 = new Bezahlmethode( "Lastschrift", "IBAN 1005 0123 0123 0123 00");
        //Bezahlmethode bezahlmethode3 = new Bezahlmethode("Kreditkarte", "1234 5678 9123 1234");

        LocalDate gb1 = LocalDate.parse("06.06.1960", formatter);
        LocalDate gb2 = LocalDate.parse("04.06.1967", formatter);
        LocalDate gb3 = LocalDate.parse("04.10.1950", formatter);
        LocalDate gb4 = LocalDate.parse("10.06.1972", formatter);
        LocalDate gb5 = LocalDate.parse("14.05.1984", formatter);
        LocalDate gb6 = LocalDate.parse("07.04.1970", formatter);
        Reiseagentur reiseagentur = new Reiseagentur("Magic Holidays Reiseagentur", "UST-IDNRDE812524001", adresseRA);
        Kunde kunde1 = new Privatkunde(Anrede.Herr, "Hans", "Peter", gb1, "0049123456", "HHP@gmail.com");
        kunde1.setAdresse(adresseK1);
        Kunde kunde2 = new Privatkunde(Anrede.Frau, "Gisela", "Peter", gb2, "004987654", "GHP@gmail.com");
        kunde2.setAdresse(adresseK2);
        kunde2.setAdresse(adresseK1);
        Kunde kunde3 = new Privatkunde(Anrede.Frau, "Petra", "Schubert", gb3, "00498987654", "PSchubert@gmx.com");
        kunde3.setAdresse(adresseK3);

        // ----------------------- Geschäftskunden -----------------------------------------

        Adresse adresseGK1 = new Adresse("Hermannstrasse", "11", "Berlin", "15698");
        Adresse adresseGK2 = new Adresse("Hermannstrasse", "11", "Berlin", "15698");
        Adresse adresseGK3 = new Adresse("Oligarchenplatz", "101", "München", "10098");

        // Bezahlmethode bezahlmethodeGK1 = new Bezahlmethode("Rechnung","5464 5678 9123 1234");
        // Bezahlmethode bezahlmethodeGK2 = new Bezahlmethode("Rechnung","1234 4562 4564 5345");
        // Bezahlmethode bezahlmethodeGK3 = new Bezahlmethode("Rechnung","2342 5678 2357 1234");

        Kunde gKunde1 = new Geschaeftskunde(Anrede.Herr, "Sundar", "Pichai", gb4, "+840384209305", "McSunday@google.com", "Google");
        gKunde1.setAdresse(adresseGK1);
        Kunde gKunde2 = new Geschaeftskunde(Anrede.Herr, "Mark", "Zuckerberg", gb5, "+64080912385", "marki@facebook.com", "Facebook");
        gKunde2.setAdresse(adresseGK2);
        Kunde gKunde3 = new Geschaeftskunde(Anrede.Frau, "MacKenzie", "Bezos", gb6, "+49234234521", "BigMac@amazon.com", "Amazon");
        gKunde3.setAdresse(adresseGK3);

        LocalDate date1 = LocalDate.parse("01.02.2019", formatter);
        LocalDate date2 = LocalDate.parse("05.02.2019", formatter);
        LocalDate date3 = LocalDate.parse("02.02.2019", formatter);
        LocalDate date4 = LocalDate.parse("14.12.2019", formatter);
        LocalDate date5 = LocalDate.parse("24.12.2019", formatter);
        LocalDate date6 = LocalDate.parse("01.02.2019", formatter);
        LocalDate date7 = LocalDate.parse("30.03.2019", formatter);
        LocalDate date8 = LocalDate.parse("13.11.2019", formatter);
        LocalDate date9 = LocalDate.parse("03.12.2019", formatter);
        LocalDate date10 = LocalDate.parse("16.10.2019", formatter);
        Reservierungen reservierung = new Flugreservierung(date1, 638, "Berlin TXL", "SGN", "BR06", kunde1);
        Reservierungen reservierung_2 = new Flugreservierung(date2, 638, "SGN", "TXL", "BR07", kunde1);
        Reservierungen reservierung_3 = new Hotelreservierung(date3, 1300.59, "The Reverie Saigon", 3, kunde1);

        kunde1.addReservierung(reservierung);
        kunde1.addReservierung(reservierung_2);
        kunde1.addReservierung(reservierung_3);
        Reservierungen reservierung2 = new Flugreservierung(date4, 888, "LAX", "GNS", "LA5", kunde2);
        Reservierungen reservierung21 = new Flugreservierung(date5, 888, "GNS", "LAX", "LA6", kunde2);
        kunde2.addReservierung(reservierung2);
        kunde2.addReservierung(reservierung21);
        Reservierungen reservierung3 = new Flugreservierung(date6, 638, "Berlin TXL", "SGN", "BR06", kunde3);
        Reservierungen reservierung31 = new Flugreservierung(date7, 638, "SGN", "TXL", "BR05", kunde3);
        kunde3.addReservierung(reservierung3);
        kunde3.addReservierung(reservierung31);
        Reservierungen reservierung4 = new Hotelreservierung(date8, 187.50, "Warsteiner Ehrenhaus", 1, gKunde1);
        gKunde1.addReservierung(reservierung4);
        Reservierungen reservierung5 = new Hotelreservierung(date9, 290.55, "Adlon Berlin", 1, gKunde2);
        gKunde2.addReservierung(reservierung5);
        Reservierungen reservierung6 = new Hotelreservierung(date10, 1087.50, "Dreamresort Hawaii", 4, gKunde2);
        gKunde3.addReservierung(reservierung6);


        reiseagentur.addKunde(kunde1);
        reiseagentur.addKunde(kunde2);
        reiseagentur.addKunde(kunde3);

        reiseagentur.addKunde(gKunde1);
        reiseagentur.addKunde(gKunde2);
        reiseagentur.addKunde(gKunde3);


        while (true) {


            System.out.println("Wollen Sie mit GUI (1) oder CLI (2) fortfahren?");
            String eingabe = sc.next();

            switch (eingabe) {
                case "1":
                    JFrame frame = new Oberfläche(reiseagentur);
                    frame.setVisible(true);
                    return;


                case "2":
                    while (true) {

                        menu();
                        System.out.println("Bitte Auswahl treffen:");
                        String choice = sc.next();


                        switch (choice) {

                            case "1":
                                reiseagentur.addKunde(setKunde(reiseagentur, 'p'));
                                continue;

                            case "2":
                                reiseagentur.addKunde(setKunde(reiseagentur, 'g'));
                                continue;

                            case "3":
                                if (makeReservation(reiseagentur) == false) System.err.println("Unsuccesfull!");
                                continue;

                            case "4":
                                // findCustomerReservationByCustomerNumber()
                                showCustomerByCID(reiseagentur);
                                continue;


                            case "5":
                                // findCustomerReservationByName()
                                showCustomerByName(reiseagentur);
                                // kundennummern

                                continue;

                            case "6":
                                findReservationByNumber(reiseagentur);

                                continue;

                            case "7":
                                showSortedCustomers(reiseagentur.sortedCustomers());
                                continue;

                            case "8":
                                //overviewPaymentMethods(reiseagentur);
                                continue;
                            case "9":
                                //System.out.println(MapUtil.sortByValue(Kunde.getOverviewPaymentMethods()));
                                //System.out.println(Kunde.getReservationIndex().toString());
                                sortReservationsByDate();
                                continue;

                            case "10":
                                exportData(reiseagentur);
                                continue;

                            case "11":
                                reiseagentur = importData();
                                continue;

                            case "12":
                                exportKundenCSV(reiseagentur);
                                continue;


                            case "13":
                                reservierungCheckout(reiseagentur);
                                continue;

                            case "14":
                                showBuchhaltungsListe();
                                continue;

                            case "15":
                                showAuditingListe();
                                continue;


                            case "16":
                                System.exit(0);


                            case "17":                                                                   // nur für Debug
                                for (Kunde kunde : reiseagentur.getKunden()) {
                                    if (kunde != null) {
                                        System.out.println(kunde.getKundenNummer() + " " + kunde.getAllReservations().toString());
                                    }
                                }
                                System.out.println("--------------------------------------------");
                                reiseagentur.print();

                                continue;

                            case "18":
                                JFrame ob = new Oberfläche(reiseagentur);
                                ob.setVisible(true);


                            default:
                                System.err.println("Gültige Eingabe tätigen (1-7)");

                        }
                    }

                default:
                    continue;
            }
        }


    }



    private static void showAuditingListe() {
        int i = 1;
        for (Zahlung zahlung: Auditing.getInstance().getBezahlungen()) {
            System.out.println(i + ". Zahlung: \n" + "\tBezahlmethode: " + zahlung.getBezahlmethode().getBezeichnung() + "\n\tBetrag: " + zahlung.getBetrag());
            i++;
        }
    }

    private static void showBuchhaltungsListe() {
        int i = 1;
        for (Zahlung zahlung: Buchhaltung.getInstance().getZahlungen()) {
            System.out.println(i + ". Zahlung: \n" + "\tBezahlmethode: " + zahlung.getBezahlmethode().getBezeichnung() + "\n\tBetrag: " + zahlung.getBetrag());
            i++;
        }
    }

    private static void reservierungCheckout(Reiseagentur rg) {

        Reservierungen reservierung = findReservationByNumber(rg);

        if (reservierung == null)
            return;

        double betrag = reservierung.getSumme();
        System.out.println("Wie soll die Summe " + betrag + " der Reservierung " + reservierung.getReservierungsNummer() + " bezahlt werden?");

        String array[] = {"Kreditkarte", "EC-Karte", "Rechnung", "Abbrechen"};

        for (int i = 0; i< array.length; i++)
            System.out.println("\n" + (1+i) + ". " + array[i]);

        System.out.println("Bezahlmethode:");

        Kasse kasse = Kasse.getInstance();

        String eingabe = sc.next();

        switch (eingabe){
            case "1":
                kasse.setBezahlstrategie(new KreditKarteStrategie());
                break;
            case "2":
                kasse.setBezahlstrategie(new ECKarteStrategie());
                break;
            case "3":
                kasse.setBezahlstrategie(new RechnungStrategie());
                new Zahlung(betrag, new RechnungStrategie());
                break;
            case "4":
                return;
            default:
                System.err.println("Ungültige Eingabe!");
                return;
        }
        kasse.bezahlen(betrag);
    }

    /**
     * prints out list of all customers sorted by lastname
     *
     * @param sortedCustomers list of sorted customers
     */


    private static void showSortedCustomers(ArrayList<Kunde> sortedCustomers) {
        for (Kunde kunden: sortedCustomers){
            System.out.println(kunden.getName());
        }
    }

    /**
     * imports reiseagentur object
     *
     * @return Reiseagentur object from given file path
     */



    private static Reiseagentur importData() {
        Reiseagentur rg = null;
        String archiveFile = "";
        System.out.print("Archive:\t");
        archiveFile = sc.next();
        System.out.println(archiveFile);
        rg = IOUtils.importReisebueroObject(archiveFile);
        System.out.println("Hotel Import hat " + (rg == null ? "nicht " : "") + "funktioniert");
        try {
            //System.out.println(rg.toString());
            //rg.print();
            System.out.println(rg.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            System.err.println("Zieldatei nicht vorhanden!");
        }
        return rg;
    }

    /**
     * exports reiseagentur object
     *
     * @param reiseagentur reiseagentur whichs data gets exported
     */

    private static void exportData(Reiseagentur reiseagentur) {

        File testFile = new File("");
        String currentPath = testFile.getAbsolutePath();
        System.out.println("current path is: " + currentPath);

        String filePathString = null;
        System.out.println("Please enter filepath:");

        filePathString = sc.next();

        System.out.println(filePathString);
        try {
            File filePath = new File(filePathString);
            if (IOUtils.exportReisebuero(reiseagentur, filePath)) {
                System.out.println("Daten erfolgreich exportiert");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Fehler!");
        }

    }

    /**
     * exports list of customers ordered by last name as csv file
     *
     * @param rg reiseagentur whichs customers gets exported
     */

    private static void exportKundenCSV(Reiseagentur rg) {
        String filePath = "";
        System.out.print("Zieldatei:\t");
        filePath = sc.next();
        if (!filePath.endsWith("Kundenliste.csv"))
            filePath += "\\Kundenliste.csv";
        List<Kunde> kunden = rg.sortedCustomers();
        boolean result = IOUtils.exportKunden(kunden, filePath);
        System.out.println("Export hat " + (result ? "" : "nicht ") + "funktioniert!");
        if (result)
            System.out.println("Es wurden " + rg.getKunden().size() + " Datensätze in " + filePath + " geschrieben.");
    }

    /**
     * sort reservations by date
     *
     * finds and displays Reservations from certain day
     */

    private static void sortReservationsByDate() {
        System.out.println("Tage an denen es Reservierungen gibt:");
        System.out.println(Kunde.getReservationIndex().keySet().toString());
        LocalDate date = addDate();
        System.out.println(date);
        for (LocalDate dates: Kunde.getReservationIndex().keySet()){
            if (dates.isEqual(date)) {
                TreeSet<Reservierungen> reservations = (TreeSet<Reservierungen>) Kunde.getReservationIndex().get(date);
                for (Reservierungen r: reservations){
                    System.out.println(r.getKunde().getName() + r.toString());
                }
            }
            return;
            //System.out.println(dates);
            //System.out.println(date);
        }
        System.err.println("Datum nicht vorhanden!");
    }

    /**
     * find reservation by number
     *
     * @param reiseagentur reiseagentur where customer belongs to
     * @return the Reservierung
     */

    private static Reservierungen findReservationByNumber(Reiseagentur reiseagentur) {
        System.out.println("Reservierungsnummer:");
        String reservierungsnummer = sc.next();

        for (Kunde kunde : reiseagentur.getKunden()) {
            if (kunde != null) {
                for (Reservierungen reservierung : kunde.getAllReservations()) {
                    if (reservierung != null && reservierung.getReservierungsNummer().equals(reservierungsnummer)) {
                        System.out.println(reservierung.toString());
                        System.out.println("\n Zugehörige Kundennummer: " + reservierung.getKundenNummer());
                        return reservierung;
                    }
                }

            }
        }
        System.err.println("Reservierung mit dieser Nummer existiert nicht!");
        return null;
    }

    /**
     * shows customer by customer number and prints it
     *
     * @param reiseagentur reiseagentur where customer belongs to
     */

    private static void showCustomerByCID(Reiseagentur reiseagentur) {
        Kunde kunde = findCustomerByCustomerNumber(reiseagentur);
        try {
            System.out.println(kunde.toString());
        }
        catch (NullPointerException npe){
            System.err.println("Back to menu");
        }
    }

    /**
     * find customer by name
     *
     * @param reiseagentur reiseagentur where customer belongs to
     * @return the kunde
     */



    /**
     * shows customer by name
     *
     * @param reiseagentur reiseagentur where customer belongs to
     * @return  boolean if succesfull or not
     */
    private static boolean showCustomerByName(Reiseagentur reiseagentur) {
        Kunde kunde = findCustomerReservationByCustomerName(reiseagentur);
        try {
            System.out.println(kunde.toString());
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }


    private static Kunde findCustomerReservationByCustomerName(Reiseagentur reiseagentur) {
        System.out.println("Kundenname:");
        String name = sc.next() + " " + sc.next();
        System.out.println(name);
        for (Kunde kunde: reiseagentur.getKunden()) {
            if (kunde != null && (kunde.getVorName() + " " + kunde.getNachName()).equals(name)) {
                return kunde;
            }
        }
        System.out.println("Kunde nicht vorhanden");
        return null;
    }

    /**
     * finds Customer by CID
     *
     * @param reiseagentur reiseagentur where customer belongs to
     * @return the kunde
     */

    private static Kunde findCustomerByCustomerNumber(Reiseagentur reiseagentur) {
        showAllCustomers(reiseagentur);
        System.out.println("Kundennummer:");
        while (true) {
            String kundenNummer = sc.next();
            if (kundenNummer.equals("Stop")){
                break;
            }
            for (Kunde kunde: reiseagentur.getKunden()) {
                if ((kunde != null)) {
                    if (kunde.getKundenNummer().equals(kundenNummer)) {
                        System.out.println(kunde.getKundenNummer());
                        return kunde;
                    }
                }
            }
            System.err.println("Kunde nicht vorhanden! Bitte gültige Kundennumer eingeben:" +
                    "\n \"Stop\" um Abbzubrechen");
        }
        return null;
    }

    /**
     * sets Anrede
     *
     * @return the Anrede Enum
     */

    private static Anrede setAnredeEnum() {
        while (true) {
            String anrede = scanner("Anrede (Herr / Frau)");
            switch (anrede) {
                case "Herr":
                    return Anrede.Herr;

                case "Frau":
                    return Anrede.Frau;

                default:
                    System.err.println("Bitte gültige Eingabe tätigen! (Herr/Frau)");
            }
        }
    }

    /**
     * boolean makeReservation makes reservation
     *
     *@param reiseagentur reiseagentur where customer belongs to
     * @return the boolean if successful or not
     */

    private static boolean makeReservation(Reiseagentur reiseagentur) {
        Reservierungen reservierung = null;
        String choice = null;
        while (true) {
            System.out.println("Flug- oder Hotelreservierung? (f/h)");
            choice = sc.next();
            if (choice.equals("f")) {
                reservierung = new Flugreservierung();
                //findCustomerByCustomerNumber(reiseagentur).addReservierungen(reservierung); // getKundeByCId and set Reservation for him
                System.out.println("Tag der Reise:");
                reservierung.setDatum(addDate());
                ((Flugreservierung) reservierung).setAbflughafen(scanner("Abflughafen"));
                ((Flugreservierung) reservierung).setZielflughafen(scanner("Zielflughafen"));
                System.out.println("Flugnummer");
                ((Flugreservierung) reservierung).setFlugNummer(sc.next());
                System.out.println("Gesamtkosten in €");
                reservierung.setSumme(doubleScanner());
                break;
            } else if (choice.equals("h")) {
                reservierung = new Hotelreservierung();
                System.out.println("Tag der Reise:");
                reservierung.setDatum(addDate());
                ((Hotelreservierung) reservierung).setHotelName(scanner("Hotelname"));
                System.out.println("Anzahl Nächte:");
                ((Hotelreservierung) reservierung).setReiseDauer(intScanner());
                System.out.println("Gesamtkosten in €:");
                reservierung.setSumme(doubleScanner());
                break;
            } else System.err.println("Bitte gültige Eingabe tätigen!");
        }
        Kunde kunde = findCustomerByCustomerNumber(reiseagentur);
        if (kunde != null) {
            reservierung.setKunde(kunde);
            kunde.addReservierung(reservierung);
            return true;
        }
        return false;
    }

    /**
     * Add date local date.
     *
     * @return the local date
     */
    public static LocalDate addDate() {
        System.out.println("Bitte gülgites Datum im Format dd.mm.yyyy eingeben:");
        while (true) {
            try {
                LocalDate localDate = LocalDate.parse(sc.next(), formatter);
                return localDate;
            } catch (Exception e) {
                if (sc.hasNext())
                    sc.next();
                System.err.println("Bitte erneut versuchen! (01.01.2001):");
            }
        }
    }


    /**
     * menu shows menu.
     *
     */
    private static void menu() {
        System.out.println("\n(01) Privatkunde anlegen\n" +
                "(02) Geschäftskunde anlegen\n" +
                "(03) Reservierung anlegen und Kundennummer zuordnen\n" +
                "(04) Kunde mit Reservierungen anzeigen (Auswahl durch Kundennummer)\n" +
                "(05) Kunde mit Reservierungen anzeigen (Auswahl durch Name)\n" +
                "(06) Reservierung anzeigen (Auswahl durch Reservierungsnummer)\n" +
                "(07) Alle Kunden sortiert nach aufsteigendem Vornamen, aufsteigendem Nachnamen zeigen\n" +
                "(08) Übersicht der Bezahlmethoden (Bezeichnungen) sortiert nach absteigender Häufigkeit zeigen\n" +
                "(09) Alle Reservierungen eines Datums sortiert nach Nachnamen der Kunden zeigen \n" +
                "(10) Daten Export\n" +
                "(11) Daten Import\n" +
                "(12) Kunden nach Namen sortiert als CSV-Datei exportieren\n" +
                "(13) Reservierung Checkout\n" +
                "(14) Buchhaltungsliste zeigen\n" +
                "(15) Auditingliste zeigen\n" +
                "(16) Beenden\n");
    }


    /**
     * Sets kunde.
     *
     * @param reiseagentur the reiseagentur
     * @param typ          the typ
     * @return the kunde
     */
    public static Kunde setKunde(Reiseagentur reiseagentur, char typ) {
        Kunde kunde = null;
        String firmenName = null;

        Anrede anrede = setAnredeEnum();

        String vorname = scanner("Vorname");

        String nachname = scanner("Nachname:");

        System.out.println("Geburtsdatum:");
        LocalDate geburtsDatum = addDate();

        if (typ == 'g') {
            System.out.println("Firmenname:");
            firmenName = sc.next();
        }

        System.out.println("Telefonnummer:");
        String telefonNummer = sc.next();

        System.out.println("Email-Adresse:");
        String emailAdresse = sc.next();

        if (typ == 'p') {
            kunde = new Privatkunde(vorname, nachname, geburtsDatum, telefonNummer, emailAdresse);
            kunde.setAnrede(anrede);
        } else {
            kunde = new Geschaeftskunde(vorname, nachname, geburtsDatum, telefonNummer, emailAdresse, firmenName);
            kunde.setAnrede(anrede);

        }
        kunde.setAdresse(addAdresse(kunde));
        System.out.println(kunde.toString());
        return kunde;
    }

    /**
     * Overview payment methods.
     * sorts List
     *
     * @param rg the rg
     */
    /*public static void overviewPaymentMethods(Reiseagentur rg) {
        HashMap<String, Integer> unsortMap = Kunde.getOverviewPaymentMethods();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(unsortMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }*/

    /**
     * Int scanner takes int.
     *
     * @return the int
     */
    public static int intScanner() {
        while (true) {
            try {
                return sc.nextInt();

            } catch (InputMismatchException i) {
                System.err.println("Bitte ganze Zahl eingeben");
                sc.next();
            }
        }
    }

    /**
     * Double scanner takes double.
     *
     * @return the double
     */
    public static double doubleScanner() {
        while (true) {
            try {
                return sc.nextDouble();

            } catch (InputMismatchException i) {
                System.out.println("Bitte mit Nachkommastelle eingeben (zb. 1,0)");
                sc.next();
            }
        }
    }

    /**
     * Show all customers.
     *
     * @param rg the rg
     */
    public static void showAllCustomers(Reiseagentur rg){
        System.out.println("\nKundenliste:");
        for(Kunde kunde: rg.getKunden()) {
            if (kunde != null) {
                System.out.println("\tName: " + kunde.getName() + " CID: " + kunde.getKundenNummer());
            }
        }
    }


    /**
     * adds adresse takes kunde.
     *
     * @param k the k
     * @return the adresse
     */
    public static Adresse addAdresse(Kunde k) {

        System.out.println("Adressdaten:\n");

        String strassenname = scanner("Strassenname");

        System.out.println("Hausnummer:");
        String hausnummer = sc.next();

        String stadt = scanner("Stadt");

        System.out.println("Plz:");
        String plz = sc.next();

        Adresse adresse = new Adresse(strassenname, hausnummer, stadt, plz);

        return adresse;
    }

    /**
     * Scanner string.
     *
     * @param argument the argument
     * @return the string
     */
    public static String scanner(String argument){

        boolean success = false;
        System.out.println(argument + ":");
        String input;
        while (!success){
            input = sc.next() + sc.nextLine();
            boolean test = validateString(input);
            if (!test){
                System.err.println("Eingabe darf keine Zahlen enthalten!");
                System.out.println(argument + ":");
                success = false;
            }
            else if (test){
                System.out.println("Eingabe erfolgreich: " + input);
                success = true;
                return input;
            }
        }
        return null;
    }

    /**
     * validates if String contains numbers
     *
     * @return the boolean
     */

    private static boolean validateString(String input){
        char[] array = input.toCharArray();
        int test;

        for(char element: array){
            if (Character.isDigit(element)){
                return false;
            }
        }
        return true;

    }


}
