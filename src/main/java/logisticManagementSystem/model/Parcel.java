package logisticManagementSystem.model;

import logisticManagementSystem.Size;
import logisticManagementSystem.State;


import java.util.Objects;
import java.util.UUID;

public class Parcel {

    private UUID id;
    private String name;
    private Size size;
    private double weight;
    private String recipient;
    private String sender;
    private Locker senderLocker;
    private Locker recipientLocker;
    private State state;

    public Parcel(String id, String name, Size size, double weight, String recipient, String sender, Locker senderLocker, Locker recipientLocker) {
        this.id = UUID.fromString(id);
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderLocker = senderLocker;
        this.recipientLocker = recipientLocker;
        this.state = State.WAITING_FOR_PICKING_UP;
    }

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


    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public Locker getSenderLocker() {
        return senderLocker;
    }

    public Locker getRecipientLocker() {
        return recipientLocker;
    }

    public State getState() {
        return state;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Double.compare(parcel.weight, weight) == 0 && id.equals(parcel.id) && name.equals(parcel.name) && size == parcel.size && recipient.equals(parcel.recipient) && sender.equals(parcel.sender) && senderLocker.equals(parcel.senderLocker) && recipientLocker.equals(parcel.recipientLocker) && state == parcel.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, size, weight, recipient, sender, senderLocker, recipientLocker, state);
    }
}
