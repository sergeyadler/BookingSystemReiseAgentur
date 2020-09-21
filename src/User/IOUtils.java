package User;

import Objekte.Kunde;
import Objekte.Reiseagentur;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Io utils.
 */
public class IOUtils {

    /**
     * Export reisebuero boolean.
     *
     * @param reiseagentur the reiseagentur
     * @param filePath     the file path where reisebüro object gets exported to
     * @return the boolean
     */
    public static boolean exportReisebuero(Reiseagentur reiseagentur, File filePath){
        boolean success = false;

        String fileName = reiseagentur.getName().replaceAll("\\s+","") + "-" + new SimpleDateFormat("yyyy-MM-dd").format((new Date()));
        fileName += ".ser";
        System.out.println(fileName);

        ObjectOutputStream oos = null;
        boolean structureCreated = filePath.exists() && filePath.isDirectory();
        // System.out.println("exists:" + filePath.exists());
        // System.out.println("direcotry:" + filePath.isDirectory());
        // System.out.println(structureCreated);

        if (!structureCreated)
            structureCreated = filePath.mkdirs();
        if (structureCreated)
            try {
                oos = new ObjectOutputStream(new FileOutputStream(new File(filePath, fileName)));
                oos. writeObject(reiseagentur);
                oos.flush();

                success = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (oos != null)
                    try {
                        oos.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
            }
        return success;
    }

    /**
     * Import reisebuero object reiseagentur.
     *
     * @param filePath the file path where Reisebüro object get imported from
     * @return the reiseagentur
     */
    public static Reiseagentur importReisebueroObject(String filePath){
        File file = new File(filePath);
/*      System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.isFile());*/
        if (!file.exists() || !file.canRead() || !file.isFile())
            return null;

        ObjectInputStream ois = null;

        Reiseagentur importedReiseagentur = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Object importedObject = ois.readObject();
            if (importedObject != null && importedObject instanceof Reiseagentur)
                importedReiseagentur = (Reiseagentur) importedObject;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)
                try{
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return importedReiseagentur;

    }

    /**
     * Export kunden boolean.
     *
     * @param kunden   the kunden
     * @param filePath the file path where customerlist is gonna be saved, File needs to be created in advance!
     * @return the boolean
     */
    public static boolean exportKunden(List<Kunde> kunden, String filePath){

        boolean success = false;

        FileWriter fw = null;
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory())
            System.out.println("Datei " + file + " existiert schon und wird überschrieben!");
        try {
            if (file.isDirectory())
                filePath = filePath + "\\Kundenliste.csv";
            file = new File(filePath);
            fw = new FileWriter(file);
            fw.append("Nachname; Vorname; Anzahl der Reservierungen; E-Mailadresse\n");
            for (Kunde kunde: kunden)
                fw.append(kunde.getNachName() + ";" + kunde.getVorName() + ";" + kunde.getAnzahlReservierungen() + ";" + kunde.getEMailAdresse() + "\n");

            success = true;
            fw.flush();
        }
        catch (FileNotFoundException fe) {
            fe.printStackTrace();
            System.err.println("File not found!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }
}
