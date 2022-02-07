import logisticManagementSystem.Address;
import logisticManagementSystem.LogisticManager;
import logisticManagementSystem.model.Locker;
import logisticManagementSystem.model.Parcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class LockerCrudTest {

    List<Locker> lockerList;
    LogisticManager manager;
    LinkedList<Parcel> parcelList;
    Locker locker;

    @BeforeEach
    public void setUp() {
        lockerList = new LinkedList<>();
        locker = new Locker("QWE-12", "QWER123", new Address("Bydgoska", "Krakow", "40-566"), parcelList);
        lockerList.add(locker);
        manager = new LogisticManager(lockerList);
    }

    @Test
    void addLocker() {
        //given
        List<Locker> before = new LinkedList<>(lockerList);
        Locker toAdd = new Locker("OOO-99", "LLLL888", new Address("Timessquare","Newyork","99-066"),new LinkedList<>());

        //when
        manager.addLocker(toAdd);

        //then
        Assertions.assertAll(
                () -> assertThat(before.size()).isEqualTo(1),
                () -> assertThat(before).doesNotContain(toAdd),
                () -> assertThat(manager.getLockerList().contains(toAdd)).isTrue(),
                () -> assertThat(manager.getLockerList().size()).isNotZero().isEqualTo(2)
        );
    }

    @Test
    void deleteLocker() {
        //given
        List<Locker> before = new LinkedList<>(lockerList);

        //when
        manager.deleteLocker("QWE-12");

        //then
        Assertions.assertAll(
                () -> assertThat(before).isNotEmpty(),
                () -> assertThat(before).contains(locker),
                () -> assertThat(manager.getLockerList()).doesNotContain(locker),
                () -> assertThat(manager.getLockerList()).isEmpty()
        );
    }

    @Test
    void updateLockerInfo() {
        //given
        Address address = new Address("Czarnowiejska", "Warsaw", "40-999");
        Locker lockerBeforeUpdate = locker;
        String nameBeforeUpdate = locker.getName();
        Address addressBeforeUpdate = locker.getAddress();
        String expectedName = "TTTT123";

        //when
        manager.updateLockerInfo("QWE-12", "TTTT123", address);

        //then
        Assertions.assertAll(
                () -> assertThat(lockerBeforeUpdate).isSameAs(locker),
                () -> assertThat(nameBeforeUpdate).isNotEqualTo(locker.getName()),
                () -> assertThat(locker.getName()).isEqualTo(expectedName),
                () -> assertThat(addressBeforeUpdate).isNotEqualTo(locker.getAddress()),
                () -> assertThat(locker.getAddress()).isEqualTo(address)
        );
    }


}
