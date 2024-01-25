package main;

import mock.MockBuffer;
import mock.MockConsumer;
import mock.MockProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;


public class BufferTest {
    @Mock private Item mockItem;
    Buffer buffer;
    MockProducer mockProducer;
    MockConsumer mockConsumer;
    @BeforeEach
    public void initBuffer(){
        buffer = new Buffer();
        mockConsumer = new MockConsumer(buffer);
        mockProducer = new MockProducer(buffer);
    }
    @Test
    @DisplayName("Buffer return true when adding an item")
    public void addReturnTrueIfSuccessful(){

        assertTrue(mockProducer.addItem(mockItem));
    }
    @Test
    @DisplayName("Buffer returns the same object when removing")
    public void removeRemoveOneItem(){
        mockProducer.addItem(mockItem);
        assertEquals(mockItem,mockConsumer.removeItem());
    }

    @Test
    @DisplayName("Throws Exception when removing from empty buffer")
    public void removeFromEmptyBuffer() {
        Thread thread = new Thread(() -> assertThrows(InterruptedException.class, mockConsumer::removeItem));
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(thread);
            executorService.shutdownNow();
        }
    }
    @Test
    @DisplayName("Test if adding and removing affects the internal buffer")
    public void bufferAddingAndRemoving(){
        MockBuffer mockBuffer = new MockBuffer();
        MockProducer mockProducer1 = new MockProducer(mockBuffer);
        MockConsumer mockConsumer1 = new MockConsumer(mockBuffer);
                assertTrue(mockBuffer.isEmpty());
                mockProducer1.addItem(mockItem);
                assertFalse(mockBuffer.isEmpty());
                mockConsumer1.removeItem();
                assertTrue(mockBuffer.isEmpty());
    }
    @Test
    @DisplayName("Adding to a buffer after trying to remove")
    public void removeThenAddToBuffer() throws InterruptedException {
        MockBuffer mockBuffer = new MockBuffer();
        MockProducer mockProducer1 = new MockProducer(mockBuffer);
        MockConsumer mockConsumer1 = new MockConsumer(mockBuffer);
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(mockConsumer1);
            synchronized (mockBuffer){
                assertTrue(mockBuffer.isEmpty());
                mockProducer1.addItem(mockItem);
                assertFalse(mockBuffer.isEmpty());
            }
        }
        Thread.sleep(500);
        assertTrue(mockBuffer.isEmpty());

    }
}
