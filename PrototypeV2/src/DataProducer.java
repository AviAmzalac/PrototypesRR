
import java.util.Random;

public class DataProducer implements Runnable {

    DataQueue dataQueue = Main.dataQueue;

    @Override
    public void run() {
        Random random = new Random();
        //random.setSeed(123456);
        while (true) {
            dataQueue.addFloat(Float.valueOf(random.nextFloat()*100));
        }
    }
}
