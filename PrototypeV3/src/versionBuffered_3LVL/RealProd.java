package versionBuffered_3LVL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class RealProd implements Runnable {

    Random random = new Random();

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    boolean flag=true;
    Consommateur concConso;

    public RealProd(Consommateur concConso) throws FileNotFoundException {
        this.concConso = concConso;
    }

    public float sendFloat() {
        return random.nextFloat()*100;
    }

    @Override
    public void run() {
        while (true) {
            float myFloat = sendFloat();
            System.out.println("Prod : Je donne " + myFloat + " au RcC");
            try {
                concConso.calculate(myFloat);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
