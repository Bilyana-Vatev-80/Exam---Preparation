package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.getCount() < this.capacity) {
            this.data.add(astronaut);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(a -> a.getName().equals(name));
    }

    public Astronaut getOldestAstronaut() {
        return this.data.stream().max(Comparator.comparing(Astronaut::getAge)).orElse(null);
    }

    public Astronaut getAstronaut(String name) {
        return this.data.stream().filter(a -> a.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:",this.getName()))
        .append(System.lineSeparator());
        for (Astronaut a : this.data) {
            sb.append(a).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
