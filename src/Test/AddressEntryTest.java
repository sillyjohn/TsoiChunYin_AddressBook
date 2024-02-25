package Test;

import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {
    AddressBook ab;
    AddressEntry entry;
    @BeforeEach
    void setUp(){
        entry = new AddressEntry("John", "Tsoi", "123 Main St", "Anytown", "State", 12345, "555-1234", "john@example.com");

    }

    @Test
    void testToString() {

        String expectedString = "John Tsoi\n123 Main St\nAnytown, State 12345\njohn@example.com\n555-1234\n";
        assertEquals(expectedString, entry.toString(), "toString does not match expected format");
    }

    @Test
    void getFirstName() {
        String expectedString = "John";
        assertEquals(expectedString,entry.getFirstName(),"The output should be matched.");
    }

    @Test
    void getLastName() {
        String expectedString = "Tsoi";
        assertEquals(expectedString,entry.getLastName(),"The output should be matched.");
    }

    @Test
    void getStreet() {
        String expectedString = "123 Main St";
        assertEquals(expectedString,entry.getStreet(),"The output should be matched.");
    }

    @Test
    void getCity() {
        String expectedString = "Anytown";
        assertEquals(expectedString,entry.getCity(),"The output should be matched.");
    }

    @Test
    void getState() {
        String expectedString = "State";
        assertEquals(expectedString,entry.getState(),"The output should be matched.");
    }

    @Test
    void getZip() {
        int expectedString = 12345;
        assertEquals(expectedString,entry.getZip(),"The output should be matched.");
    }


    @Test
    void getPhone() {
        String expectedString = "555-1234";
        assertEquals(expectedString,entry.getPhone(),"The output should be matched.");
    }

    @Test
    void getEmail() {
        String expectedString = "john@example.com";
        assertEquals(expectedString,entry.getEmail(),"The output should be matched.");
    }

    @Test
    void setFirstName() {
        entry.setFirstName("Fion");
        assertAll("setters", () -> assertEquals("Fion", entry.getFirstName()));
    }

    @Test
    void setLastName() {
        entry.setLastName("Lee");
        assertAll("setters", () -> assertEquals("Lee", entry.getLastName()));
    }

    @Test
    void setStreet() {
        entry.setStreet("abc st");
        assertAll("setters", () -> assertEquals("abc st", entry.getStreet()));
    }

    @Test
    void setCity() {
        entry.setCity("HK");
        assertAll("setters", () -> assertEquals("HK", entry.getCity()));
    }

    @Test
    void setState() {
        entry.setState("CA");
        assertAll("setters", () -> assertEquals("CA", entry.getState()));
    }

    @Test
    void setZip() {
        entry.setZip(12345);
        assertAll("setters", () -> assertEquals(12345, entry.getZip()));
    }

    @Test
    void setPhone() {
        entry.setPhone("911");
        assertAll("setters", () -> assertEquals("911", entry.getPhone()));
    }

    @Test
    void setEmail() {
        entry.setEmail("fion@gmail.com");
        assertAll("setters", () -> assertEquals("fion@gmail.com", entry.getEmail()));
    }
}