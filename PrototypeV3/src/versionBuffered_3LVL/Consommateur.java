package versionBuffered_3LVL;

import java.io.IOException;

public interface Consommateur {
    void calculate(float f) throws IOException;
    void finished() throws IOException;
}
