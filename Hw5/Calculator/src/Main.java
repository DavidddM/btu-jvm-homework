package btu;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // იმდენად მომწონს ჩემი სოლუშენი, რო განულებაც არ მეწყინება :D
        // რო გამინულოთ და თავიდან დაწერის უფლება მომცეთ, პითონის ძრავით დავწერ :D

        String expression;
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsEngine = manager.getEngineByName("js");
        try {
            System.out.println(String.valueOf(jsEngine.eval(expression)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
