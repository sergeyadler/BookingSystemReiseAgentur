
package User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author s0571777 Sergey Orlov
 *
 * @version 1.0
 *  * Testklasse zum Testen
 *
 * * Bitte nicht beachten
 *
 * */
public class test {

    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");



    public static void main(String[] args) {



        //System.out.println(addDate().toString());
       /* LocalDate date1 = LocalDate.parse("01.02.2019", formatter);
        System.out.println(date1.toString());*/

    }
    public static LocalDate addDate() {
        while (true) {
            try {
                LocalDate localDate = LocalDate.parse(sc.next(), formatter);
                return localDate;
            } catch (Exception e) {
                System.out.println("FAil");
            }
        }
    }

    public static String checkString(){

        String eingabe = "Hallo123";

        eingabe.toLowerCase();

        return eingabe;

    }
}
