package versionBuffered_2LVL;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String outputFile = "src/versionBuffered_2LVL/outputsBuffered.txt";

        BlockingQueue<Float> buffer = new ArrayBlockingQueue<>(200);

        RealConso consommateur = new RealConso(outputFile);
        Consommateur realConcurrentConso = new RealConcurrentConso(consommateur, buffer);
        RealProd producteur = new RealProd(realConcurrentConso);
        RealConcurrentProd realConcurrentProd = new RealConcurrentProd(buffer, consommateur);
        consommateur.setRealConcurrentProd(realConcurrentProd);

        Arbiter arbiter = new Arbiter(consommateur);

        Thread Th_arbiter = new Thread(arbiter);
        Thread Th_producteur = new Thread(producteur);
        Thread Th_consommateur = new Thread(realConcurrentProd);

        Th_producteur.start();
        Th_consommateur.start();
        Th_arbiter.start();

    }
}
