package logisticManagementSystem.model;

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
    private State state;

    public Parcel() {
        id = UUID.randomUUID();
    }

    public Parcel(String name, String size, double weight, String recipient, String sender, Locker senderLocker, Locker recipientLocker, State state) {
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
                ", senderLocker=" + senderLocker.getName() +
                ", recipientLocker=" + recipientLocker.getName() +
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
