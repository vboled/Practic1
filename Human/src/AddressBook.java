import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private ArrayList<Human> addressBook = new ArrayList<Human>();

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressBook=" + addressBook +
                '}';
    }

    public static Calendar getDate(String[] mas) {                                  // Парсим mas, который содержит одну запись в файле addressBook.txt
        String[] date = mas[2].split("\\.");
        return new GregorianCalendar(Integer.parseInt(date[2]),
                Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]));
    }

    public static Address getAddress(String[] mas) {
        return new Address(mas[3], mas[4], Integer.parseInt(mas[5]),
                Integer.parseInt(mas[6]));
    }

    public ArrayList<Human> getNeighbors(String street) {                   // Находим всех людей, живущих на одной улице
        return new ArrayList<Human>(addressBook.stream().filter(u ->
                u.getAddress().getStreet().equals(street)).collect(Collectors.toList()));
    }

    public ArrayList<Human> getHumansByAddress(Address address) {           // Находим всех людей живущих по переданному адресу
        return new ArrayList<Human>(addressBook.stream().filter(u ->
                u.getAddress().equals(address)).collect(Collectors.toList()));
    }

    public ArrayList<Human> getOldestHuman() {                              // Находим старейшего человека в адресной книге
        Comparator<Human> comparator = Comparator.comparing(obj -> obj.getBirthDate());
        Calendar oldestDate = Collections.min(addressBook, comparator).getBirthDate();
        return new ArrayList<Human>(addressBook.stream().filter(u ->
                u.getBirthDate().equals(oldestDate)).collect(Collectors.toList()));
    }

    public ArrayList<Human> getHumansByDates(Calendar begin, Calendar end) { // Находим всех людей, родившихся в интервале от begin до end
        return new ArrayList<Human>(addressBook.stream().filter(u ->
                u.getBirthDate().getTime().after(begin.getTime()) &&
                        u.getBirthDate().getTime().before(end.getTime())).collect(Collectors.toList()));
    }

    public ArrayList<Human> getYoungestHuman() {                             // Находим самого молодого человека в адресной книге
        Comparator<Human> comparator = Comparator.comparing(obj -> obj.getBirthDate());
        Calendar youngestDate = Collections.max(addressBook, comparator).getBirthDate();
        return new ArrayList<Human>(addressBook.stream().filter(u ->
                u.getBirthDate().equals(youngestDate)).collect(Collectors.toList()));
    }

    public ArrayList<Human> getHumansBySurname(String surname) {            // Находим всех людей по переданной фамилии
        return new ArrayList<Human>(addressBook.stream().filter(u ->
                u.getSurname().equals(surname)).collect(Collectors.toList()));
    }

    public AddressBook(String fileName) throws Exception {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        scanner.useDelimiter(" ");
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] mas = str.split(" ");
            Calendar calendar = AddressBook.getDate(mas);
            Address address = AddressBook.getAddress(mas);
            addressBook.add(new Human(mas[0], mas[1], calendar, address));
        }
        fr.close();
    }
}
