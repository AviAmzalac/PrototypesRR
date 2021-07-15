package versionNormale_1LVL;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "src/versionNormale/inputs.txt";
        String outputFile = "src/versionNormale/outputsNormal.txt";

        Consommateur consommateur = new RealConso(outputFile);
        RealProd realProd = new RealProd(inputFile,consommateur);
        realProd.run();


    }
}
