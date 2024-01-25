package main;

import mock.MockItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    @DisplayName("Test that toString return lowercase id")
    void testToString() {
        Item item = new Item("StringTest");
        assertEquals(item.toString(), "stringtest");
    }

    @Test
    @DisplayName("Test that setting a new id changes the ID")
    void setId() {
        Item item = new Item("StringTest");
        item.setId("NewId");
        assertEquals(item.toString(), "newid");
        assertNotEquals(item.toString(), "stringtest");
    }

    @Test
    @DisplayName("Throws NPE when ID is null")
    void generateItemWithNull() {
        assertThrows(NullPointerException.class,() -> new Item(null));
    }
    @Test
    @DisplayName("Test wheter constructing actually sets the internal ID field")
    void constructCheckTest(){
        MockItem mockItem = new MockItem("TestString");
        assertEquals("teststring",mockItem.getId());

    }
}


