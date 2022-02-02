package logisticManagementSystem;

import logisticManagementSystem.model.Locker;
import logisticManagementSystem.model.Parcel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class LogisticManager {
    private final List<Locker> lockerList;

    public LogisticManager() {
        lockerList = new LinkedList<>();
    }

    public void addLocker(String id, String name, Address address) {
        lockerList.add(new Locker(id, name, address));
        System.out.println("Locker added\n");
    }

    public void deleteLocker(String id) {
        Locker locker = findLockerById(id);
        if (locker != null) {
            lockerList.remove(findLockerById(id));
            System.out.println("Locker successfully deleted");
        } else System.out.println("no such parcel");
    }

    private Locker findLockerById(String id) {
        return lockerList.stream()
                .filter(locker -> locker.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Parcel findParcelById(String parcelId) {
        return Objects.requireNonNull(lockerList.stream().filter(locker -> locker.getParcelById(parcelId) != null)
                .findFirst().orElse(null)).getParcelById(parcelId);

    }

    public void displayAllLockers() {
        for (Locker locker : lockerList)
            System.out.println(locker);
    }

    public void displayAllParcelsByLockerId(String lockerId) {
        for (Parcel parcel : findLockerById(lockerId).getParcelList())
            System.out.println(parcel);
    }

    public void displayLockersByCity(String city) {
        lockerList.stream()
                .filter(l -> l.getAddress().getCity().equals(city))
                .forEach(System.out::println);
    }

    public void updateLockerName(String id, String name) {
        Locker locker = findLockerById(id);
        if (locker != null)
            findLockerById(id).setName(name);
        else
            System.out.println("no such locker");
    }

    public void updateParcel(String parcelId, String parcelName, Size size, double weight, String recipient, String sender, String recipientLockerId, String senderLockerId, State state) {
        Parcel parcel = findParcelById(parcelId);
        Locker recipientLocker = findLockerById(recipientLockerId);
        Locker senderLocker = findLockerById(senderLockerId);
        if (parcel != null && recipientLocker != null && senderLocker != null) {
            parcel.setName(parcelName);
            parcel.setSize(size);
            parcel.setWeight(weight);
            parcel.setRecipient(recipient);
            parcel.setSender(sender);
            parcel.setState(state);
            parcel.setRecipientLocker(recipientLocker);
            parcel.setSenderLocker(senderLocker);
            System.out.println("Parcel info updated");
        } else
            System.out.println("no such parcel");
    }

    public void updateLockerAddress(String id, String address) {
        Locker locker = findLockerById(id);
        if (locker != null)
            locker.setAddress(address);
        else
            System.out.println("no such locker");
    }

    public void updateLockerInfo(String id, String name, String address) {
        updateLockerName(id, name);
        updateLockerAddress(id, address);
        System.out.println("Locker information updated");
    }

    public void addParcel(String name, Size size, double weight, String recipient, String sender, String senderLockerId, String recipientLockerId) {
        Locker senderLocker = findLockerById(senderLockerId);
        Locker recipientLocker = findLockerById(recipientLockerId);
        if (senderLocker != null && recipientLocker != null) {
            findLockerById(senderLockerId).getParcelList().add(new Parcel(name, size, weight, recipient, sender, findLockerById(senderLockerId), findLockerById(recipientLockerId)));
            System.out.println("Parcel added\n");
        } else
            System.out.println("no such Locker");
    }

    public void deleteParcel(String parcelId) {
        Parcel parcel = findParcelById(parcelId);
        if (parcel != null) {
            Objects.requireNonNull(lockerList.stream().filter(locker -> locker.getParcelById(parcelId) != null)
                            .findFirst().orElse(null))
                    .getParcelList()
                    .remove(parcel);
            System.out.println("Parcel deleted");
        } else
            System.out.println("no such parcel");
    }

    @Override
    public String toString() {
        return "LockerManager{" +
                "lockerList=" + lockerList +
                '}';
    }
}