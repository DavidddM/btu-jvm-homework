package btu;

import java.util.Scanner;

public class B extends A {
    // კარგად ვერ მივხვდი პირობას, ეს მეთოდი 1 და მეთოდი 2 მშობლის მეთოდის ოვერრაიდს უნდა აკეთებდეს თუ
    // ცალკე მეთოდი უნდა იყოს; ლოგიკურად მსჯელობის შედეგად მივედი დასკვნამდე, რომ:
    // ოვერრაიდის გარეშე საბკლასის მეორე მეთოდს აზრი ეკარგება, რადგანაც სუპერკლასის x მნიშვნელობა არასდროს
    // შეივსება და ჯამი ყოველთვის y-ის ტოლი იქნება;
    // გამომდინარე ამ ყველაფრიდან, პირველ მეთოდს ოვერრაიდი გავუკეთე, მეორე მეთოდი კი ახალი შევქმენი;

    private int y;

    public void Method1() {
        super.Method1();
        Scanner sc = new Scanner(System.in);
        try {
            this.y = sc.nextInt();
        }
        catch(Exception ex) {
            System.out.println("An error has occurred: " + ex);
        }
    }

    public int childMethod2() {
        return this.x + this.y;
    }

}
