package versionBuffered_2LVL;

import java.io.IOException;

public class Arbiter implements Runnable {

    Consommateur conso;

    public Arbiter(Consommateur conso) {
        this.conso = conso;
    }

    public void endExperience() throws IOException {
        conso.finished();
        System.out.println("Fin d'exp");
        System.exit(0);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long end = start + 2*1000;
        while (start < end) {
            start = System.currentTimeMillis();
        }
        try {
            endExperience();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
