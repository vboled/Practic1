import java.awt.geom.AffineTransform;

public class Address {
    String city;
    String street;
    int house;
    int apartment;

    public Address(String city, String street, int house, int apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + city + '\'' +
                ", Street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Address add = (Address) obj;
        return this.city.equals(add.city) && this.street.equals(add.street) &&
                this.apartment == add.apartment && this.house == add.house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
