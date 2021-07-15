package versionBuffered_2LVL;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class RealConcurrentProd implements Runnable{

    BlockingQueue<Float> buffer;

    Consommateur consommateur;

    public RealConcurrentProd(BlockingQueue<Float> buffer, Consommateur consommateur){
        this.buffer = buffer;
        this.consommateur=consommateur;
    }

    public float takeFromBuffer() throws InterruptedException {
        System.out.println("RdP : J'ai lu "+buffer.peek()+" et je l'ai donné au consommateur");
        return buffer.take();

    }

    @Override
    public void run() {
        while(true){
            try {
                consommateur.calculate(takeFromBuffer());
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
