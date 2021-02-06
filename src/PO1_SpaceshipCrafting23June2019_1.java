import java.util.*;

public class PO1_SpaceshipCrafting23June2019_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(liquids::offer);
        ArrayDeque<Integer> items = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(items::push);

        int glass = 0; //25
        int aluminium = 0; //50
        int lithium = 0; //75
        int carbonFiber = 0; //100

        boolean materialIsFull = false;

        while (!liquids.isEmpty() && !items.isEmpty()) {
            int liquid = liquids.poll();
            int item = items.pop();

            if (liquid + item == 25) {
                glass++;
            } else if (liquid + item == 50) {
                aluminium++;
            } else if (liquid + item == 75) {
                lithium++;
            } else if (liquid + item == 100) {
                carbonFiber++;
            } else {
                items.push(item += 3);
            }
            if (glass > 0 && aluminium > 0 && lithium > 0 && carbonFiber > 0) {
                materialIsFull = true;
                break;
            }
        }
        if (materialIsFull) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn’t have enough materials to build the spaceship.");
        }
        printLiquids(liquids);

        printItems(items);
        System.out.println("Aluminium " + aluminium);
        System.out.println("Carbon Fiber " + carbonFiber);
        System.out.println("Glass " + glass);
        System.out.println("Lithium " + lithium);
    }

    private static void printItems(ArrayDeque<Integer> items) {
        String itemsRes = "Physical items left: ";
        if (items.isEmpty()) {
            itemsRes += "none";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!items.isEmpty()) {
                sb.append(items.pop());
                if (items.isEmpty()) {
                    break;
                }
                sb.append(", ");
            }
            itemsRes += sb.toString().trim();
        }
        System.out.println(itemsRes);
    }

    private static void printLiquids(ArrayDeque<Integer> liquids) {
        String liquidsRes = "Liquids left: ";
        if (liquids.isEmpty()) {
            liquidsRes += "none";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!liquids.isEmpty()) {
                sb.append(liquids.poll());
                if (liquids.isEmpty()) {
                    break;
                }
                sb.append(", ");
            }
            liquidsRes += sb.toString().trim();
        }
        System.out.println(liquidsRes);
    }
}
