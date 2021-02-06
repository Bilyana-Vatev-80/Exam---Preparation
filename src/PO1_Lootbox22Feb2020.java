import java.util.*;

public class PO1_Lootbox22Feb2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <Integer> firstLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")) //queue
                .map(Integer ::parseInt)
                .forEach(firstLootBox::offer);
        ArrayDeque <Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))//stack
                .map(Integer::parseInt)
                .forEach(secondLootBox::push);
        int sum = 0;


        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()){
            int firstBox = firstLootBox.peek();
            int secondBox = secondLootBox.peek();

            if((firstBox + secondBox) % 2 == 0){
                sum += firstBox + secondBox;
                firstLootBox.poll();
                secondLootBox.pop();
            } else {
                firstLootBox.offer(secondLootBox.pop());
            }
        }
        if(firstLootBox.isEmpty()){
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if(sum >= 100){
            System.out.printf("Your loot was epic! Value: %d",sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d",sum);
        }
    }
}
