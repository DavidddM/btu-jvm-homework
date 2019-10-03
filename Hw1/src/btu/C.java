package btu;
import java.util.Scanner;

public class C {
    private int a, b, c;

    public void Method1() {
        Scanner sc = new Scanner(System.in);
        try {
            this.a = sc.nextInt();
            this.b = sc.nextInt();
            this.c = sc.nextInt();
        }
        catch(Exception ex) {
            System.out.println("An error has occurred: " + ex);
        }
    }

    public int Method2() {
        return this.a % 10;
    }

    public int Method3() {
        return (int)Math.floor(Math.abs(this.b) / Math.pow(10, Math.floor(Math.log10(Math.abs(this.b)))));
    }

    public int Method4() {
        int sum=0, tmp=this.c;
        for(;tmp>0; sum+=tmp%10, tmp/=10);
        return sum;
    }

    public int Method5() {
        int result = this.Method2() * this.Method3();
        System.out.println(result);
        return result;
    }

    public void Method6() {
        System.out.println(this.Method3() + this.Method5());
    }
}
