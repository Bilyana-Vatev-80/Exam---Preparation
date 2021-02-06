import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PO1_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> lilasStack = new ArrayDeque<> ();
        Arrays.stream (scanner.nextLine ().split (", ")).map (Integer::parseInt).forEach (lilasStack::push);
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<> ();
        Arrays.stream (scanner.nextLine ().split (", ")).map (Integer::parseInt).forEach (rosesQueue::offer);
        int wreaths      = 0;
        int spareFlowers = 0;

        while (!lilasStack.isEmpty () && !rosesQueue.isEmpty ()) {
            int lilas = lilasStack.pop ();
            int roses = rosesQueue.poll ();
            while (lilas + roses > 15) {
                lilas -= 2;
            }
            if (lilas + roses == 15) {
                wreaths++;
            } else spareFlowers += lilas + roses;
        }
        wreaths = wreaths + spareFlowers/15;
        if (wreaths >= 5) {
            System.out.printf ("You made it, you are going to the competition with %d wreaths!",wreaths);
        }
        else {
            System.out.printf ("You didn't make it, you need %d wreaths more!", 5-wreaths);
        }
    }
}
