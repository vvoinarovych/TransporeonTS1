package logisticManagementSystem.model;

import logisticManagementSystem.Size;
import logisticManagementSystem.State;


import java.util.UUID;

public class Parcel {

    private final UUID id;
    private String name;
    private Size size;
    private double weight;
    private String recipient;
    private String sender;
    private Locker senderLocker;
    private Locker recipientLocker;
    private State state;

    public Parcel(String name, Size size, double weight, String recipient, String sender, Locker senderLocker, Locker recipientLocker) {
        id = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderLocker = senderLocker;
        this.recipientLocker = recipientLocker;
        this.state = State.WAITING_FOR_PICKING_UP;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSenderLocker(Locker senderLocker) {
        this.senderLocker = senderLocker;
    }

    public void setRecipientLocker(Locker recipientLocker) {
        this.recipientLocker = recipientLocker;
    }

    public void setState(State state) {
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


}
