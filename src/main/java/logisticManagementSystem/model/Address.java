package logisticManagementSystem.model;

public class Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }
    public Address(String fullAddress){
        String[] divided = fullAddress.split(", ");
        street =divided[0];
        city = divided[1];
        postalCode = divided[2];
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }
}
