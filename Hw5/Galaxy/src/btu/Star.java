package btu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Star {
    static int idSeq=0;

    int id;
    String name;
    double diameter;
    double temp;

    private static ArrayList<Star> stars = new ArrayList<>();

    Star(String name, double diameter, double temp) {
        this.id = Star.idSeq;
        this.name = name;
        this.diameter = diameter;
        this.temp = temp;
        Star.idSeq++;
        stars.add(this);
        try {
            this.writeInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Star GetByID(int id) {
        return Star.stars.stream()
                .filter(star -> star.id==id)
                .findAny()
                .orElse(null);
    }

    public static Star GetByName(String name) {
        return Star.stars.stream()
                .filter(star -> star.name.equals(name))
                .findAny()
                .orElse(null);
    }

    public void PrintInfo() {
        System.out.println("ინფორმაცია ვარსკსვლავზე:");
        System.out.println(String.format("\tვარსკვლავის სახელი: %s (%d)\n\tვარსკვლავის დიამეტრი: %f\n\tვარსკვლავის ტემპერატურა: %f", this.name, this.id, this.diameter, this.temp));
        if(Planet.GetAllPlanetsByStarID(this.id).size() != 0) {
            System.out.println("გარშემო მოძრავი პლანეტები: ");
            for (Planet planet : Planet.GetAllPlanetsByStarID(this.id)) {
                planet.PrintInfo();
            }
        }
    }

    private void writeInfo() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.name+".txt", true));
        writer.write(String.format("\tვარსკვლავის სახელი: %s (%d)\n\tვარსკვლავის დიამეტრი: %f\n\tვარსკვლავის ტემპერატურა: %f", this.name, this.id, this.diameter, this.temp));
        writer.close();
    }

    public static void PrintAllStarInfo() {
        StringBuilder sb = new StringBuilder();
        for (Star star: Star.stars) {
            sb.append(String.format("%d - %s, ", star.id, star.name));
        }
        System.out.println(sb.toString());
    }

    public static int StarsCount() {
        return Star.stars.size();
    }

    public static ArrayList<Star> GetAllStars() {
        return Star.stars;
    }
}
