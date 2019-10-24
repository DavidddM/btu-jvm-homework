package btu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("function.txt"));
        String line;
        float min, max;
        min=max=Float.parseFloat(reader.readLine());
        while((line=reader.readLine()) != null) {
            min = Float.min(Float.parseFloat(line), min);
            max = Float.max(Float.parseFloat(line), max);
        }
        System.out.println(String.format("Min: %f\nMax: %f", min, max));
    }
}
