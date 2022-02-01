package logisticManagementSystem.model;

import java.util.LinkedList;
import java.util.List;

public class Locker {
    private final String id;
    private String name;
    private Address address;
    private final List<Parcel> parcelList;

    public Locker(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        parcelList = new LinkedList<>();
    }

    public List<Parcel> getParcelList() {
        return parcelList;
    }

    public Parcel getParcelById(String parcelId) {
        return parcelList.stream()
                .filter(parcel -> String.valueOf(parcel.getId()).equals(parcelId))
                .findFirst()
                .orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", packageList=" + parcelList +
                '}';
    }
}
