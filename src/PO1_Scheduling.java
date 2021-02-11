import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PO1_Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <Integer> valueQueue = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                        .forEach(valueQueue ::push);

        ArrayDeque <Integer> threads = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(threads ::offer);

       int number = Integer.parseInt(scanner.nextLine());

       while (valueQueue.peek() != number){
           if(threads.peek() >= valueQueue.peek()){
               threads.poll();
               valueQueue.pop();
           } else {
               threads.poll();
           }
       }
        System.out.printf("Thread with value %d killed task %d%n",threads.peek(),number);
        String output = threads.stream()
                .map(String ::valueOf)
                .collect(Collectors.joining(" ")) ;
        System.out.println(output);
    }
}
