package versionBuffered_3LVL;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        String outputFile = "src/versionBuffered_3LVL/outputsBuffered.txt";

        BlockingQueue<Float> buffer = new ArrayBlockingQueue<>(200);

        RealConso realConso = new RealConso(outputFile);
        Consommateur realConcurrentConso = new RealConcurrentConso(realConso, buffer);
        RealProd realProd = new RealProd(realConcurrentConso);
        RealConcurrentProd realConcurrentProd = new RealConcurrentProd(buffer, realConso, 200);
        realConso.setRealConcurrentProd(realConcurrentProd);

        Thread Th_producteur = new Thread(realProd);
        Thread Th_consommateur = new Thread(realConcurrentProd);

        Th_producteur.start();
        Th_consommateur.start();
    }
}