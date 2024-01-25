package mock;

import main.Buffer;
import main.Item;
import main.Producer;

public class MockProducer implements Producer, Runnable {
    private final Buffer buffer;
    public MockProducer(Buffer buffer){
        this.buffer = buffer;

    }
    @Override
    public void run() {
    }
    public boolean addItem(Item item){
        return buffer.add(item);

    }

    @Override
    public void stopRunning() {

    }
}
