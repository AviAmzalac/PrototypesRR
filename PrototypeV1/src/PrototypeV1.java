package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PrototypeV1 {

    public static ArrayList<Integer> getRandomArray(int nbNumber, int bound, long ... values){
        ArrayList<Integer> myarray = new ArrayList<>();
        int randomNumber;
        Random objGenerator = new Random();
        if(values.length==1){
            objGenerator.setSeed(values[0]);
        }
        for (int iCount = 0; iCount < nbNumber; iCount++) {
            randomNumber = objGenerator.nextInt(bound);
            myarray.add(randomNumber);
        }
        return myarray;
    }

    //OTHER REFACTORING WAY
    /*//Return an array of int based on the fixed number of iteration, bound
    public static ArrayList<Integer> getRandomArray(int nbNumber, int bound, Random objGenerator) {
        ArrayList<Integer> myarray = new ArrayList<>();
        int randomNumber;
        for (int iCount = 0; iCount < nbNumber; iCount++) {
            randomNumber = objGenerator.nextInt(bound);
            myarray.add(randomNumber);
        }
        return myarray;
    }

    //Return an array of int based on the fixed number of iteration, bound and passed seed
    public static ArrayList<Integer> getRandomArrayFromASeed(int nbNumber, int bound, long seed) {
        Random objGenerator = new Random();
        objGenerator.setSeed(seed);
        return getRandomArray(nbNumber, bound, objGenerator);
    }*/

    //Gather a long from a file passed in arguments
    public static long gatherRootSeed(String myFile) throws FileNotFoundException {
        File seedFile = new File(myFile);
        Scanner myReader = new Scanner(seedFile);
        String seed = myReader.nextLine();
        long myseed = Long.valueOf(seed);
        return myseed;
    }

    //Add one by one int and a line break to the file, from an array respectively passed in arguments
    public static void addToFile(ArrayList<Integer> myarray, FileWriter output) throws IOException {
        for (int i = 0; i < myarray.size(); i++) {
            output.write(myarray.get(i).toString());
            if (i < myarray.size() - 1) {
                output.write(System.getProperty("line.separator"));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);
        FileWriter output = new FileWriter(args[1]);
        Scanner myReader = new Scanner(input);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            float myFloat = Float.parseFloat(data);
            output.write(Integer.toString((int) myFloat));
            output.write(System.getProperty("line.separator"));
        }
        if(args.length<3) {
            System.out.println("Without seed.");
            //addToFile(getRandomArray(100, 100, new Random()), output);
            addToFile(getRandomArray(100,100),output);
        } else {
            System.out.println("With seed.");
            //addToFile(getRandomArrayFromASeed(100, 100,gatherRootSeed(args[2])), output);
            addToFile(getRandomArray(100,100,gatherRootSeed(args[2])),output);
        }
        output.close();
        System.out.println("Successfully wrote to the file.");
    }
}
