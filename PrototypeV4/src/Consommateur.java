import java.io.IOException;
import java.util.ArrayList;

public interface Consommateur {
    void calculate(float f) throws IOException;
    void finished() throws IOException;
    ArrayList<Integer> compute() throws IOException;
}
