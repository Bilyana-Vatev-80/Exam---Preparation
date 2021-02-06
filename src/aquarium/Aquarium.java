package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishPoll;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishPoll = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int detFishInPool() {
        return this.fishPoll.size();
    }

    public void add(Fish fish) {
        boolean isUnique = true;
        if (this.fishPoll.size() < this.capacity) {
            for (Fish fishFromPool : this.fishPoll) {
                if (fishFromPool.getName().equals(fish.getName())) {
                    isUnique = false;
                    break;
                }
            }
        } else {
            isUnique = false;
        }
        if (isUnique) {
            this.fishPoll.add(fish);
        }
    }
    public boolean remove(String name){
       return  this.fishPoll.removeIf(f -> f.getName().equals(name));
    }
    public Fish findFish(String name){
        for (Fish fish : this.fishPoll) {
            if(fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d",this.getName(),this.getSize()));
        sb.append(System.lineSeparator());
        for (Fish fish : this.fishPoll) {
            sb.append(fish.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
