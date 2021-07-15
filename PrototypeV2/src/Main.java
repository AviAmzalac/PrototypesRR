import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static DataQueue dataQueue = new DataQueue();
    public static void main(String[] args) throws IOException {

        DataProducer dataProducer = new DataProducer();
        Thread threadDataProducer = new Thread(dataProducer);
        ArrayList<Float> arrayListOfFloat = new ArrayList<>();
        threadDataProducer.start();
        FileWriter output = new FileWriter("outputFIFOFloat.txt");
        int counter= 0;
        while(dataQueue.getStock()>0 && counter<200) {
            output.write(String.valueOf(Float.valueOf(dataQueue.getHead())));
            if(counter<199){
                output.write(System.getProperty("line.separator"));
            }
            arrayListOfFloat.add(dataQueue.takeFloat());
            counter++;
        }
        System.out.println("Tableau Full");
        output.close();
        threadDataProducer.stop();

        ArrayList<Integer> arrayListOfInt = new ArrayList<>();

        for (int i = 0; i < arrayListOfFloat.size(); i++) {
            arrayListOfInt.add(arrayListOfFloat.get(i).intValue());
        }

        for (int i = 0; i < arrayListOfInt.size(); i++) {
            System.out.println(arrayListOfInt.get(i));
        }
    }
}
