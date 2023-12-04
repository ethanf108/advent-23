package in;

import java.io.IOError;
import java.io.IOException;

public class IO {

    public static String readFileFully(String num){
        try (var in = IO.class.getResourceAsStream(num + ".txt")) {
            final StringBuilder sb = new StringBuilder();
            int c;
            while((c = in.read()) != -1){
               sb.append((char)c);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IOError(e);
        }
    }
}
