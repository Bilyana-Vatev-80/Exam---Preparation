package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    List <Player> roster;

    public Guild (String name,int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPlayer(Player player){
        if(this.roster.size() < this.capacity){
            this.roster.add(player);
        }
    }
    public boolean removePlayer(String name){
        return this.roster.removeIf(p -> p.getName().equals(name));
    }
    public void promotePlayer(String name){
        for (Player player: this.roster ) {
            if(player.getName().equals(name)){
                player.setRank("Member");
                break;
            }
        }
    }
    public void demotePlayer(String name){
        for (Player player: this.roster ) {
            if(player.getName().equals(name)){
                player.setRank("Trial");
                break;
            }
        }
    }
    public Player[] kickPlayersByClass(String clazz){
        Player[] players = this.roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        for (Player player : players) {
            this.roster.removeIf(p -> p.getName().equals(player.getName()));
        }
        return players;
    }
    public int count(){
        return this.roster.size();
    }
    public String report(){
      StringBuilder sb = new StringBuilder();
      sb.append(String.format("Players in the guild: %s:%n",this.getName()));
        for (Player player : this.roster) {
            sb.append(player.toString())
            .append(System.lineSeparator());
        }
      return sb.toString().trim();
    }
}
