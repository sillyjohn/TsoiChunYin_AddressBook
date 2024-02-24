package address.data;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    @Test
    void testEmptyAddressBook(){
        AddressBook emptyAddressBook = new AddressBook();
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        emptyAddressBook.list();

        assertTrue(outContent.toString().contains(""));
    }
    @Test
    void list() {
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void readFromFile() {
    }

    @Test
    void find() {
    }

    @Test
    void getNumberOfContact() {
    }
}