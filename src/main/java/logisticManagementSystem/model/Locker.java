package logisticManagementSystem.model;

import logisticManagementSystem.Address;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Locker {
    private final String id;
    private String name;
    private Address address;
    private final List<Parcel> parcelList;


    public Locker(String id, String name, Address address, List<Parcel> parcelList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.parcelList = parcelList;
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
        this.address =address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locker locker = (Locker) o;
        return id.equals(locker.id) && name.equals(locker.name) && address.equals(locker.address) && parcelList.equals(locker.parcelList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, parcelList);
    }
}
