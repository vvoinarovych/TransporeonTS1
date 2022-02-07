import logisticManagementSystem.Address;
import logisticManagementSystem.LogisticManager;
import logisticManagementSystem.model.Locker;
import logisticManagementSystem.model.Parcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class LogisticManagerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    LogisticManager manager;
    List<Locker> lockerList;
    LinkedList<Parcel> parcelList;
    Locker locker1;
    Locker locker2;
    Locker locker3;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        lockerList = new LinkedList<>();
        parcelList = new LinkedList<>();
        locker1 = new Locker("QWE-12", "QWER123", new Address("Bydgoska", "Krakow", "40-566"), parcelList);
        locker2 = new Locker("QQQ-32", "TTTT123", new Address("Krolewska", "Warsaw", "40-999"), parcelList);
        locker3 = new Locker("BBB-22", "PPPP123", new Address("Kawiory", "Warsaw", "77-666"), parcelList);
        lockerList.add(locker1);
        lockerList.add(locker2);
        lockerList.add(locker3);
        manager = new LogisticManager(lockerList);
    }

    @Test
    void displayAllLockersShouldDisplayAllLockers() {
        //given
        String expected = "" + locker1 + "\r\n" + locker2 + "\r\n" +locker3;

        //when
        manager.displayAllLockers();

        //then
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void displayAllLockersByCityShouldPrintNothingIfInputIsNotExistingCity() {
        //given
        String expected = "";

        //when
        manager.displayLockersByCity("Tokio");

        //then
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void displayAllLockersByCityShouldPrintOnlyLockersInChosenCity() {
        //given
        String expected = "" + locker2 + "\r\n" + locker3;

        //when
        manager.displayLockersByCity("Warsaw");

        //then
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());

    }
    @Test
    void findLocker(){

    }
}
