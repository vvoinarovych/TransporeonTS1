package logisticManagementSystem;

import java.util.UUID;

public class Parcel {
    private final UUID id;
    private String name;
    private String size;
    private double weight;
    private String recipient;
    private String sender;
    private Locker senderLocker;
    private Locker recipientLocker;
    private PackageState state;

    public Parcel() {
        id = UUID.randomUUID();
    }

    public Parcel(String name, String size, double weight, String recipient, String sender, Locker senderLocker, Locker recipientLocker, PackageState state) {
        id = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderLocker = senderLocker;
        this.recipientLocker = recipientLocker;
        this.state = state;
    }



    @Override
    public String toString() {
        return "Package{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                ", recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", senderLocker=" + senderLocker +
                ", recipientLocker=" + recipientLocker +
                ", state=" + state +
                '}';
    }

    /**
     * id
     * name
     * size
     * weight
     * recipient
     * sender
     * sender parcel locker
     * recipient parcel locker
     * state
     */
}
