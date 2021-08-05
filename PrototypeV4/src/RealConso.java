import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RealConso implements Consommateur {

    FileWriter output;
    FileWriter outputFinal;
    boolean firstLine = true;
    ArrayList<Integer> workingArray = new ArrayList<>();

    public void setRealConcurrentProd(RealConcurrentProd realConcurrentProd) {
        this.realConcurrentProd = realConcurrentProd;
    }

    RealConcurrentProd realConcurrentProd;

    public RealConso(String f, String g) throws IOException {
        this.output = new FileWriter(f);
        this.outputFinal = new FileWriter(g);
    }


    public void writeToFile(float f) throws IOException {
        if (!firstLine) {
            output.write(System.getProperty("line.separator"));
        } else {
            firstLine = false;
        }
        output.write(Integer.toString((int) f));
    }

    public void writeToFinal(int i) throws IOException {
        if (!firstLine) {
            outputFinal.write(System.getProperty("line.separator"));
        } else {
            firstLine = false;
        }
        outputFinal.write(Integer.toString(i));
    }


    public void finished() throws IOException {
        System.out.println("[Conso : J'ai terminé" + workingArray);
        output.close();
        outputFinal.close();
        System.out.println("Array de moyennes : " + compute());
    }


    @Override
    public void calculate(float f) throws IOException {
        int tr = (int) f;
        System.out.println("Conso :  J'ajoute " + tr + " dans le tableau workingArray.");
        workingArray.add((tr));
        writeToFile(tr);
    }

    @Override
    public ArrayList<Integer> compute() throws IOException {
        ArrayList<Integer> moyenneArray = new ArrayList<>();
        int moyenne;
        for (int i = 0; i < workingArray.size()-10; i++) {
            moyenne = 0;
            for (int j = 0; j < 10; j++) {
                moyenne+=workingArray.get(i+j);
            }
            moyenneArray.add(moyenne/10);
            //-writeToFinal(moyenne/10);
        }
        return moyenneArray;
    }
}

