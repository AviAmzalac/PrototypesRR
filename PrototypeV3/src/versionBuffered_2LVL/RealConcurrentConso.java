package versionBuffered_2LVL;


import java.util.concurrent.BlockingQueue;

public class RealConcurrentConso implements Consommateur {

    RealConso conso;
    BlockingQueue<Float> buffer;

    public RealConcurrentConso(RealConso conso, BlockingQueue<Float> buffer){
        this.conso = conso;
        this.buffer = buffer;
    }

    @Override
    public void calculate(float f){
        buffer.offer(f);
        System.out.println("RdC : J'ai ajouté "+f+" au buffer");
    }

    public void finished() {
        System.out.println("RcC : J'ai terminé.");
    }
}
