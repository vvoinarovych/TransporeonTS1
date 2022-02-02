package logisticManagementSystem;

import logisticManagementSystem.model.Locker;
import logisticManagementSystem.model.Parcel;

import java.util.*;


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
        for (Locker locker : lockerList) {
            for (Parcel parcel : locker.getParcelList()) {
                if (parcel.getId().equals(UUID.fromString(parcelId))) {
                    return parcel;
                }
            }
        }
        return null;
    }

    private Locker findLockerByParcelId(String parcelId) {
        for (Locker locker : lockerList) {
            for (Parcel parcel : locker.getParcelList()) {
                if (parcel.getId().equals(UUID.fromString(parcelId))) {
                    return locker;
                }
            }
        }
        return null;
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
        Locker previousLocker = findLockerByParcelId(parcelId);
        Locker updatedLocker = findLockerById(senderLockerId);
        if (parcel != null && recipientLocker != null && updatedLocker != null) {
            if (previousLocker != updatedLocker) {
                deleteParcel(parcelId);
                addParcel(parcelId,parcelName, size, weight, recipient, sender, senderLockerId, recipientLockerId);
                findParcelById(parcelId).setState(state);
            } else {
                parcel.setName(parcelName);
                parcel.setSize(size);
                parcel.setWeight(weight);
                parcel.setRecipient(recipient);
                parcel.setState(state);
                parcel.setRecipientLocker(recipientLocker);
                parcel.setSenderLocker(updatedLocker);
                System.out.println("Parcel info updated");
            }
        }
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
        } else
            System.out.println("no such Locker");
    }

    public void addParcel(String id,String name, Size size, double weight, String recipient, String sender, String senderLockerId, String recipientLockerId) {
        Locker senderLocker = findLockerById(senderLockerId);
        Locker recipientLocker = findLockerById(recipientLockerId);
        if (senderLocker != null && recipientLocker != null) {
            findLockerById(senderLockerId).getParcelList().add(new Parcel(id, name, size, weight, recipient, sender, findLockerById(senderLockerId), findLockerById(recipientLockerId)));
        } else
            System.out.println("no such Locker");
    }


    public void deleteParcel(String parcelId) {
        Parcel parcel = findParcelById(parcelId);
        if (parcel != null) {
            lockerList.stream().filter(locker -> locker.getParcelById(parcelId) != null)
                    .findFirst().orElse(null)
                    .getParcelList()
                    .remove(parcel);
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
