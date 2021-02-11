import java.util.*;
import java.util.stream.Collectors;

public class PO1_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(ingredients::push);
        int bread = 0, cake = 0, pastry = 0, fruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            if (liquid + ingredient == 25) {
                bread++;
            } else if (liquid + ingredient == 50) {
                cake++;
            } else if (liquid + ingredient == 75) {
                pastry++;
            } else if (liquid + ingredient == 100) {
                fruitPie++;
            } else {
                ingredients.push(ingredient + 3);
            }
        }
        if (bread != 0 && cake != 0 && fruitPie != 0 && pastry != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n",
                    liquids.stream().
                            map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", ingredients.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d%n", bread, cake,
                fruitPie, pastry);
    }
}
