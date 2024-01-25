package mock;

import main.Buffer;
import main.Consumer;
import main.Item;

public class MockConsumer implements Consumer, Runnable{
    private final Buffer buffer;

    public MockConsumer(Buffer buffer) {
        this.buffer = buffer;
    }
    public Item removeItem(){
        return this.buffer.remove();
    }

    @Override
    public void run() {
            buffer.remove();
    }

    @Override
    public void stopRunning() {

    }
}
