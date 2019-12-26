package btu;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static String CurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void main(String[] args) throws IOException {
        // იმდენად მომწონს ჩემი სოლუშენი, რო განულებაც არ მეწყინება :D
        // რო გამინულოთ და თავიდან დაწერის უფლება მომცეთ, პითონის ძრავით დავწერ :D

        BufferedWriter writer = new BufferedWriter(new FileWriter("answers.txt", true));

        String expression;
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsEngine = manager.getEngineByName("js");
        try {
            String answer = String.valueOf(jsEngine.eval(expression));
            System.out.println(answer);
            writer.write(String.format("%s - %s", answer, Main.CurrentDate()));
            writer.newLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        writer.close();
    }
}
