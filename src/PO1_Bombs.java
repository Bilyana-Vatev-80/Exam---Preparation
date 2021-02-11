import java.util.*;
import java.util.stream.Collectors;

public class PO1_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(casings::push);

        int daturaBombs = 0; //40
        int cherryBombs = 0; //60
        int smokeDecoyBombs = 0; //120

        boolean fullPouch = false;

        while (!effects.isEmpty() && !casings.isEmpty()) {
            int effect = effects.peek();
            int casing = casings.poll();

            if (effect + casing == 40) {
                daturaBombs++;
                effects.poll();

            } else if (effect + casing == 60) {
                cherryBombs++;
                effects.poll();
            } else if (effect + casing == 120) {
                smokeDecoyBombs++;
                effects.poll();
            } else {
                casings.push(casing - 5);
            }

            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                fullPouch = true;
                break;
            }
        }
        if (fullPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        String effectsOutput = "Bomb Effects: " + (effects.isEmpty() ? "empty" :
                effects.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));

        System.out.println(effectsOutput);

        String casingsOutput = "Bomb Casings: " + (casings.isEmpty() ? "empty" :
                casings.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));

        System.out.println(casingsOutput);


        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);

    }
}
