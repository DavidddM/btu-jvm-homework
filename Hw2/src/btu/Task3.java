package btu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 implements Task3Interface {
    int a, b;

    public Task3(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private static ArrayList<Integer> getDivisors(int number) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(Math.abs(number)); i++) {
            if(number % i != 0) continue;
            int quo = number/i;
            if(quo == i) divisors.add(i);
            else divisors.addAll(Arrays.asList(i, quo));
        }
        Collections.sort(divisors);
        return divisors;
    }

    private static boolean isPrime(int num) {
        if(num==1) return false;
        for(int i=2; i<=num/2; i++) {
            if(num %i == 0) return false;
        }
        return true;
    }

    @Override
    public void Method1() {
        for(int i=this.a+1; i<this.b; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void Method2() {
        ArrayList<Integer> divisors = getDivisors(this.a);
        for(int d: divisors) {
            System.out.println(d);
        }
    }

    @Override
    public void Method3() {
        List<Integer> primeDivisors = getDivisors(this.b).stream().filter(Task3::isPrime).collect(Collectors.toList());
        for(int d: primeDivisors) {
            System.out.println(d);
        }
    }

    @Override
    public int Method4() {
        // ვინაიდან და რადგანაც ეს ალგორითმების კურსი არ არის, მაგრად მეზარება ახლა აქ მათემატიკური ფორმულების წერა და
        // მოდი ერეილისთში გავიტან რიცხვის ციფრებს, თუ არ მიწყენთ
        // ასევე, არ ვითვალისწინებ შემთხვევას, როდესაც ასეთი ელემენტი ერთზე მეტია, რადგანაც პირობაში მსგავსი რამ
        // მოცემული არ ყოფილა
        List<Integer> digits = new ArrayList<>();
        int b = this.b;
        while(b!=0) {
            digits.add(b%10);
            b/=10;
        }
        int num=digits.get(0);
        int maxOccurence = Collections.frequency(digits, digits.get(0));
        for(int i=1; i<digits.size(); i++) {
            int currentOccurence = Collections.frequency(digits, digits.get(1));
            if(currentOccurence > maxOccurence) {
                num = digits.get(i);
                maxOccurence = currentOccurence;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Task3 task = new Task3(10, 500);
        task.Method1();
        task.Method2();
        task.Method3();
        System.out.println(task.Method4());
    }
}
