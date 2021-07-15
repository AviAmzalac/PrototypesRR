package versionBuffered_2LVL;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Buffer {

    private int queueCapacity = 200;
    private BlockingQueue<Float> queue = new ArrayBlockingQueue<>(queueCapacity);

    public boolean addFloat(float f){
        return queue.offer(f);
    }

    public float take() throws InterruptedException {
        return queue.take();
    }

    public float getHead() {
        return queue.peek();
    }

    public int getStock() {
        return queue.size();
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public boolean isFull() {
        return queue.size() == queueCapacity;
    }
}
