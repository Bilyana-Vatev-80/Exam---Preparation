package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List <Salad> data;

    public Restaurant (String name){
        this.name = name;
        this.data = new ArrayList<>();
    }
    public void add(Salad salad){
        this.data.add(salad);
    }
    public boolean buy(String name){
        return this.data.removeIf(s -> s.getName().equals(name));
    }
    public Salad getHealthiestSalad(){
        return this.data.stream().min(Comparator.comparing(Salad::getTotalCalories))
                .orElse(null);
    }
    public String generateMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s have %d salads:%n",this.name,this.data.size()));
        for (Salad salad : this.data) {
            sb.append(salad.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
