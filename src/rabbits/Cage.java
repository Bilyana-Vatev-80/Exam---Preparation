package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
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

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    public void removeSpecies(String species) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                indexes.add(i);
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            this.data.remove(indexes.get(i) - i);
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;

        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rab = this.data.get(i);
            if (rab.getName().equals(name)) {
                rab.setAvailable(false);
                rabbit = rab;
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                rabbits.add(rabbit);
            }
        }
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at %s:" + this.name);
        sb.append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                sb.append(rabbit.toString())
                        .append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }

}
