package versionBuffered_3LVL;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class RealConcurrentProd implements Runnable{

    BlockingQueue<Float> buffer;
    Consommateur consommateur;
    int counter=0;
    int bound;


    public RealConcurrentProd(BlockingQueue<Float> buffer, Consommateur consommateur, int bound){
        this.buffer = buffer;
        this.consommateur=consommateur;
        this.bound=bound;
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
                counter++;
                if(counter == bound){
                    consommateur.finished();
                    System.exit(0);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
