import java.net.CacheRequest;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Human {
    private String name;
    private String surname;
    private Calendar birthDay;
    private Address address;

    public Human(String name, String surname, Calendar birthDate, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Calendar getBirthDate() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay.getTime() +
                ", address=" + address.toString() +
                '}';
    }

    public Address getAddress() {
        return address;
    }
}
