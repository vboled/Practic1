import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] argv) {
        try {
            AddressBook addressBook = new AddressBook("./source/addressBook.txt");
            Calendar begin = new GregorianCalendar(1950, 0, 10);
            Calendar end = new GregorianCalendar(2020, 0, 10);
            ArrayList<Human> res = addressBook.getHumansByDates(begin, end);
            for (Human h : res) {
                System.out.println(h.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
