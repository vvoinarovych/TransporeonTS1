package logisticManagementSystem.model;

import java.util.Random;
import java.util.UUID;

public class Parcel {
    public String[] forTest = new String[]{"a670bd17-f892-436e-8c76-1711f6dd7e50",
            "942e6c66-94a5-4e90-b4d4-a96e6b21ddd0",
            "344174ae-65b6-48e8-9a26-bb8d4f92f7ac",
            "3e9f6566-cffe-4279-abc5-b673629d981e",
            "ef51711e-790b-4274-ac50-7b0824444761"};

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
        id = UUID.fromString(forTest[new Random().nextInt(forTest.length)]);
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderLocker = senderLocker;
        this.recipientLocker = recipientLocker;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
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
