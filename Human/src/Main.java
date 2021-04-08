import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] argv) {
        try {
            AddressBook addressBook = new AddressBook("./source/addressBook.txt"); //fill addressBook
            // test getHumansByDates(begin, end);
            System.out.println("Example of work \"getHumansByDates\": ");
            Calendar begin = new GregorianCalendar(1950, Calendar.JANUARY, 10);
            Calendar end = new GregorianCalendar(2020, Calendar.MARCH, 10);
            ArrayList<Human> res = addressBook.getHumansByDates(begin, end);
            for (Human h : res) {
                System.out.println(h.toString());
            }
            System.out.println();

            // test getNeighbors
            System.out.println("Example of work \"getNeighbors\": ");
            res = addressBook.getNeighbors("Kosmonavtov");
            for (Human h : res) {
                System.out.println(h.toString());
            }
            System.out.println();

            // test getHumansBySurname
            System.out.println("Example of work \"getHumansBySurname\": ");
            res = addressBook.getHumansBySurname("Ivanov");
            for (Human h : res) {
                System.out.println(h.toString());
            }
            System.out.println();

            // test getOldestHuman
            System.out.println("Example of work \"getOldestHuman\": ");
            res = addressBook.getOldestHuman();
            for (Human h : res) {
                System.out.println(h.toString());
            }
            System.out.println();

            // test getYoungestHuman
            System.out.println("Example of work \"getYoungestHuman\": ");
            res = addressBook.getYoungestHuman();
            for (Human h : res) {
                System.out.println(h.toString());
            }
            System.out.println();

            // test getHumansByAddress
            System.out.println("Example of work \"getHumansByAddress\": ");
            Address address = new Address("Moscow", "Kosmonavtov", 35, 11);
            res = addressBook.getHumansByAddress(address);
            for (Human h : res) {
                System.out.println(h.toString());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
