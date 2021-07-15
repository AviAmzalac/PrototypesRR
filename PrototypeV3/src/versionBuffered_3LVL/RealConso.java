package versionBuffered_3LVL;

import java.io.FileWriter;
import java.io.IOException;

public class RealConso implements Consommateur {

    FileWriter output;
    boolean firstLine = true;

    public void setRealConcurrentProd(RealConcurrentProd realConcurrentProd) {
        this.realConcurrentProd = realConcurrentProd;
    }

    RealConcurrentProd realConcurrentProd;

    public RealConso(String f) throws IOException {
        this.output = new FileWriter(f);
    }

    public int parseFloatToInt(float f) {
        return ((int) f);
    }

    public void writeToFile(float f) throws IOException {
        if (!firstLine) {
            output.write(System.getProperty("line.separator"));
        } else {
            firstLine = false;
        }
        output.write(Integer.toString(parseFloatToInt(f)));
    }


    public void finished() throws IOException {
        System.out.println("[Conso : J'ai terminé.");
        output.close();
    }

    @Override
    public void calculate(float f) throws IOException {
        System.out.println("[Conso :  J'écris "+(int) f+" dans le fichier.");
        writeToFile(f);
    }
}

