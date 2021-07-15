package versionNormale_1LVL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RealProd implements Runnable {

    File input;
    Scanner myReader;
    Boolean flag;
    Consommateur conso;

    public RealProd(String f, Consommateur conso) throws FileNotFoundException {
        this.input = new File(f);
        this.myReader = new Scanner(input);
        this.flag = true;
        this.conso = conso;
    }

    @Override
    public void run() {
        while (flag) {
            if (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                float myFloat = Float.parseFloat(data);
                System.out.println("[" + Thread.currentThread().getName() + "] Prod : J'ajoute : "+ myFloat);
                try {
                    conso.calculate(myFloat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("[" + Thread.currentThread().getName() + "] Prod : La lecture est terminé.");
                try {
                    conso.finished();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                flag = !flag; //Arret thread
            }
        }
    }
}
