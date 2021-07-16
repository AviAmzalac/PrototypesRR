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
        if(buffer.remainingCapacity()>0) {
            buffer.offer(f);
            System.out.println("RcC : J'ai ajouté " + f + " au buffer");
        } else {
            System.out.println("RcC : Le buffer est plein");
        }
    }

    public void finished() {
        System.out.println("RcC : J'ai terminé.");
    }
}
