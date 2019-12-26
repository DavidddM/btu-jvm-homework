package btu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planet {
    static int idSeq=0;

    int id;
    String name;
    int starId;
    double distance;
    double speed;

    private static ArrayList<Planet> planets = new ArrayList<>();

    Planet(String name, int starId, double distance, double speed) {
        this.id = Planet.idSeq;
        this.name = name;
        this.starId = starId;
        this.distance = distance;
        this.speed = speed;
        Planet.idSeq++;
        planets.add(this);
        try {
            this.writeInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Planet GetByID(int id) {
        return Planet.planets.stream()
                .filter(planet -> planet.id==id)
                .findAny()
                .orElse(null);
    }

    public static Planet GetByName(String name) {
        return Planet.planets.stream()
                .filter(planet -> planet.name.equals(name))
                .findAny()
                .orElse(null);
    }

    public static ArrayList<Planet> GetAllPlanetsByStarID(int starId) {
        return (ArrayList<Planet>)Planet.planets.stream()
                .filter(planet -> planet.starId==starId)
                .collect(Collectors.toList());
    }

    // მხოლოდ დისტანციითა და სიჩქარით, იდეაში, ამ დროის დათვლა შეუძლებელია. ვაკეთებთ დაშვებას, რომ პლანეტა მოძრაობს
    // წრიულ ორბიტაზე
    public double GetTime() {
        return (this.distance * 2 * 3.14) / this.speed;
    }

    public void PrintInfo() {
        System.out.println(String.format("\tპლანეტის სახელი: %s (%d)\n\tპლანეტის ვარსკვლავი: %s\n\tპლანეტის დაშორება ვარსკვლავისგან: %f\n\tპლანეტის გადაადგილების სისწრაფე: %f\n\tდრო, ერთი სრული ბრუნის გასაკეთებლად: %f", this.name, this.id, Star.GetByID(this.starId).name, this.distance, this.speed, this.GetTime()));
    }

    private void writeInfo() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.name+".txt", true));
        writer.write(String.format(String.format("\tპლანეტის სახელი: %s (%d)\n\tპლანეტის ვარსკვლავი: %s\n\tპლანეტის დაშორება ვარსკვლავისგან: %f\n\tპლანეტის გადაადგილების სისწრაფე: %f\n\tდრო, ერთი სრული ბრუნის გასაკეთებლად: %f", this.name, this.id, Star.GetByID(this.starId).name, this.distance, this.speed, this.GetTime())));
        writer.close();
    }

    public static void PrintAllPlanetInfo() {
        StringBuilder sb = new StringBuilder();
        for (Planet planet: Planet.planets) {
            sb.append(String.format("%d - %s, ", planet.id, planet.name));
        }
        System.out.println(sb.toString());
    }

    public static ArrayList<Planet> GetAllPlanets() {
        return Planet.planets;
    }

}
