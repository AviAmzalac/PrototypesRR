package src;

import java.io.IOException;

public class Executor {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 5; i++) {
            String[] args2 = {args[0],"../tries/outputs_"+i+".txt"/*, args[1]*/};
            PrototypeV1.main(args2);
        }
    }
}