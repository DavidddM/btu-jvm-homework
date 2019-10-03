package btu;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        // Part I
//        // Class C Tests
//        C instanceC = new C();
//        instanceC.Method1();
//        System.out.println(instanceC.Method2());
//        System.out.println(instanceC.Method3());
//        System.out.println(instanceC.Method4());
//        instanceC.Method5();
//        instanceC.Method6();
//
//        // Part II
//        // Class A Tests
//        A instanceA = new A();
//        instanceA.Method1();
//        instanceA.Method2();
//        System.out.println(instanceA.oddOrEven());
//
//        // Class B Tests
//        B instanceB = new B();
//        instanceB.Method1();
//        System.out.println(instanceB.childMethod2());

        // Part III
        int a=0, b=0;
        Scanner sc = new Scanner(System.in);
        try {
            a = sc.nextInt();
            b = sc.nextInt();
        }
        catch(Exception ex) {
            System.out.println("An error has occurred: " + ex);
        }
        if(a>b) {
            int tmp=a;
            a=b;
            b=tmp;
        }
        int[] randomNumbers = new int[40];
        int countEven=0, countOdd=0, sumEven=0, sumOdd=0;
        Random rand = new Random();
        for(int i=0; i<randomNumbers.length; i++) {
            int randomNum = rand.nextInt(b-a+1)+a;
            if((randomNum&1)==1) {
                countOdd++;
                sumOdd+=randomNum;
            }
            else {
                countEven++;
                sumEven+=randomNum;
            }
            System.out.println(randomNum);
            randomNumbers[i] = randomNum;
        }
        System.out.println(String.format("Even numbers count: %d\nSum of the even numbers: %d\nOdd numbers count: %d\nSum of the odd numbers; %d", countEven, sumEven, countOdd, sumOdd));
        int min = Integer.min(sumEven, sumOdd), max = Integer.max(sumEven, sumOdd);
        for(int i=0; i<5; i++) {
            System.out.println(rand.nextInt(max-min+1)+min);
        }
    }
}
