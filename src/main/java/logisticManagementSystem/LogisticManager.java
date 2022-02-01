package logisticManagementSystem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LogisticManager {
    private final List<Locker> lockerList;

    public LogisticManager() {
        lockerList = new LinkedList<>();
    }

    public void addLocker(Locker locker) {
        lockerList.add(locker);
    }

    public void addLocker(Locker... lockers) {
        lockerList.addAll(Arrays.asList(lockers));
    }

    public void delete(String id) {
        if (findById(id) != null)
            lockerList.remove(findById(id));
        else System.out.println("No such locker");
    }

    private Locker findById(String id) {
        return lockerList.stream()
                .filter(locker -> locker.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void displayAllLockers() {
        for (Locker locker : lockerList)
            System.out.println(locker);
    }

    public void displayByCity(String city) {
        //is it worth to create class Address +
        lockerList.stream()
                .filter(l -> l.getAddress().contains(city))
                .forEach(System.out::println);
    }

    public void updateLockerName(String id, String name) {
        findById(id).setName(name);
    }

    public void updateLockerAddress(String id, String address) {
        findById(id).setAddress(address);
    }

    public void update(String id, String name, String address) {
        updateLockerName(id, name);
        updateLockerAddress(id, address);
    }

    public void addParcel(String name, String size, double weight, String recipient, String sender, String senderLockerId, String recipientLockerId, String state) {

    }

    @Override
    public String toString() {
        return "LockerManager{" +
                "lockerList=" + lockerList +
                '}';
    }
}
