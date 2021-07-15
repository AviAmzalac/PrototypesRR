import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataQueue {

    private int queueCapacity = 100;
    private BlockingQueue<Float> queue = new ArrayBlockingQueue<>(queueCapacity);

    public boolean addFloat(Float f){
        return queue.offer(f);
    }

    public Float takeFloat(){
        return queue.poll();
    }

    public Float getHead(){
        return queue.peek();
    }

    public int getStock() {
        return queue.size();
    }

    public int getQueueCapacity(){
        return queueCapacity;
    }

    public boolean isFull() {
        return queue.size() == queueCapacity;
    }
}

