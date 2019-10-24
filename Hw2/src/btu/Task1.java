package btu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {

    public static String strFunc(float x) {
        return String.valueOf((float)Math.pow(x, 2) + 2*x + 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("function.txt", true));
        for(int i=100; i<=200; i++) {
            float x = (float)i/100;
            writer.write(strFunc(x));
            writer.newLine();
        }
        writer.close();
    }
}
