package btu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1) შექმენი ვარსკვლავი\n2) შექმენი პლანეტა\n3) მიიღე ინფორმაცია პლანეტების შესახებ\n4) მიიღე ინფორმაცია ვარსკვლავების შესახებ\n5) დაათვალიერე გალაქტიკა");
            int cmd = sc.nextInt();
            sc.nextLine();
            try {
                switch (cmd) {
                    case 1:
                        System.out.println("ვარსკვლავის სახელი:");
                        String name = sc.nextLine();
                        System.out.println("ვარსკვლავის დიამეტრი:");
                        double diameter = sc.nextDouble();
                        System.out.println("ვარსკვლავის ტემპერატურა:");
                        double temp = sc.nextDouble();
                        System.out.println("შეიქმნა ახალი ვარსკვლავი! ");
                        // რადგანაც ვარსკვლავებს უშუალოდ კლასის სტატიკურ ლისთში ვინახავ, გარედან აღარ მჭირდება მიმმართველის გამოყენება
                        new Star(name, diameter, temp).PrintInfo();
                        break;
                    case 2:
                        if (Star.StarsCount() == 0) {
                            System.out.println("გთხოვთ ჯერ შექმნათ ვარსკვლავი!");
                            break;
                        }
                        System.out.println("პლანეტის სახელი:");
                        name = sc.nextLine();
                        System.out.println("ვარსკვლავის ID:\nშესაძლო ID-ები:");
                        Star.PrintAllStarInfo();
                        int starId = sc.nextInt();
                        while (Star.GetByID(starId) == null) {
                            System.out.println("ვარსკვლავის ID:\nშესაძლო ID-ები:");
                            Star.PrintAllStarInfo();
                            starId = sc.nextInt();
                        }
                        System.out.println("პლანეტის დაშორება ვარსკვლავისგან:");
                        double distance = sc.nextDouble();
                        System.out.println("პლანეტის გადაადგილების სისწრაფე:");
                        double speed = sc.nextDouble();
                        System.out.println("შეიქმნა ახალი პლანეტა! ");
                        // რადგანაც პლანეტის უშუალოდ კლასის სტატიკურ ლისთში ვინახავ, გარედან აღარ მჭირდება მიმმართველის გამოყენება
                        new Planet(name, starId, distance, speed).PrintInfo();
                        break;
                    case 3:
                        System.out.println("შეიყვანე პლანეტის ID ან დასახელება. იმისათვის, რომ მიიღო ინფორმაცია ყველა პლანეტაზე, უბრალოდ დააჭირე ენთერს");
                        Planet.PrintAllPlanetInfo();
                        String innerCmd;
                        innerCmd = sc.nextLine();
                        if(innerCmd.equals("")) {
                            for(Planet planet: Planet.GetAllPlanets()) {
                                planet.PrintInfo();
                            }
                        }
                        try {
                            if (innerCmd.matches("-?\\d+")) {
                                Planet.GetByID(Integer.parseInt(innerCmd)).PrintInfo();
                            } else {
                                Planet.GetByName(innerCmd).PrintInfo();
                            }
                        } catch (NullPointerException ex) {
                            System.out.println("ასეთი პლანეტა არ არსებობს!");
                        }
                        break;
                    case 4:
                        System.out.println("შეიყვანე ვარსკვლავის ID ან დასახელება. იმისათვის, რომ მიიღო ინფორმაცია ყველა ვარსკვლავზე, უბრალოდ დააჭირე ენთერს");
                        Star.PrintAllStarInfo();
                        innerCmd = sc.nextLine();
                        if(innerCmd.equals("")) {
                            for(Star star: Star.GetAllStars()) {
                                star.PrintInfo();
                            }
                        }
                        try {
                            if (innerCmd.matches("-?\\d+")) {
                                Star.GetByID(Integer.parseInt(innerCmd)).PrintInfo();
                            } else {
                                Star.GetByName(innerCmd).PrintInfo();
                            }
                        } catch (NullPointerException ex) {
                            System.out.println("ასეთი პლანეტა არ არსებობს!");
                        }
                        break;
                    case 5:
                        for(Star star: Star.GetAllStars()) {
                            star.PrintInfo();
                        }
                        break;
                }
            }
            catch (Exception ex) {
                System.out.println("დაფიქსირდა შეცდომა. გთხოვთ ცადოთ თავიდან!");
            }
        }
    }
}
