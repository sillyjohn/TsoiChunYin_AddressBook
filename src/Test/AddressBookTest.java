package Test;

import address.data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    AddressBook addressBook;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    void testAddAndFindContact() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "State", 12345, "email@example.com", "123-456-7890");
        addressBook.add(entry);

        // Assume `find` prints details - this is not an ideal method for testing, but demonstrates the concept
        // Ideally, `find` would return a value or change state in a testable way
        addressBook.find("Doe");
        // Assertions here would depend on how `find` is implemented to verify its behavior
    }

    @Test
    void testRemoveContact() {
        AddressEntry entry = new AddressEntry("Jane", "Doe", "124 Main St", "Anytown", "State", 12345, "jane.doe@example.com", "123-456-7891");
        addressBook.add(entry);
        // Ensure the contact is added
        // This assumes you have a method to check the presence of an entry or the size of the address book
        assertEquals(1, addressBook.getNumberOfContact());

        addressBook.remove("Doe");
        // Verify the contact has been removed
        assertEquals(0, addressBook.getNumberOfContact());
    }

    @Test
    void testReadFromFile() {
        // Setup a test file with known content
        String testFilePath = "src/Test/resources/testAddressBook.txt";
        addressBook.readFromFile(testFilePath);
        // Verify the file reading functionality by checking the address book's state
        // This might involve checking the number of entries or specific details of an added entry
        // The exact assertions will depend on the implementation details of your AddressBook class
        assertTrue(addressBook.getNumberOfContact() > 0);
    }

    // Additional tests can be written for other methods following a similar pattern
}
