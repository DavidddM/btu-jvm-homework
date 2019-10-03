package btu;

import java.util.Scanner;

public class A {
    protected int x;
    public A() {
        System.out.println("Hello");
    }

    public void Method1() {
        Scanner sc = new Scanner(System.in);
        try {
            this.x = sc.nextInt();
        }
        catch(Exception ex) {
            System.out.println("An error has occurred: " + ex);
        }
    }

    public void Method2() {
        System.out.println(this.x + 12);
    }

    public String oddOrEven() {
        return (this.x&1)==1?"Odd":"Even";
    }
}
