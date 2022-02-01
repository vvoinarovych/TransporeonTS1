package logisticManagementSystem;

import java.util.LinkedList;
import java.util.List;

public class Locker {
    private String id;
    private String name;
    private String address;
    private final List<Parcel> parcelList;


    public Locker() {
        parcelList = new LinkedList<>();
    }

    public Locker(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        parcelList = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
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
