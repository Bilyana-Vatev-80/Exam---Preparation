import java.util.*;

public class PO1_SantaPresentFactory17Dec2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> materialStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(materialStack::push);
        ArrayDeque<Integer> magicValuesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(magicValuesQueue::offer);

        Map <String,Integer> toys = new TreeMap<>();

        while (!magicValuesQueue.isEmpty() && !materialStack.isEmpty()){
            int material = materialStack.peek();
            int levels = magicValuesQueue.peek();

            int sum = material * levels;

            if(sum < 0){
                int result = material + levels;
                materialStack.pop();
                magicValuesQueue.poll();
                materialStack.push(result);

            } else if (material == 0 || levels == 0) {

                if (material == 0) {
                    materialStack.pop();
                }
                if (levels == 0) {
                    magicValuesQueue.poll();

                }
            }

            if(sum == 150){
                magicValuesQueue.poll();
                materialStack.pop();
                toys.putIfAbsent("Doll",0);
                toys.put("Doll",toys.get("Doll") + 1);
            }else if(sum == 250){
                magicValuesQueue.poll();
                materialStack.pop();
                toys.putIfAbsent("Wooden train",0);
                toys.put("Wooden train",toys.get("Wooden train") + 1);
            } else if (sum == 300){
                magicValuesQueue.poll();
                materialStack.pop();
                toys.putIfAbsent("Teddy bear",0);
                toys.put("Teddy bear",toys.get("Teddy bear") + 1);
            } else if (sum == 400){
                magicValuesQueue.poll();
                materialStack.pop();
                toys.putIfAbsent("Bicycle",0);
                toys.put("Bicycle",toys.get("Bicycle") + 1);
            } else if (sum > 0){
                magicValuesQueue.poll();
                material += 15;
                materialStack.pop();
                materialStack.push(material);
            }
        }
        if(toys.containsKey("Doll") && toys.containsKey("Wooden train") || toys.containsKey("Teddy bear") && toys.containsKey("Bicycle")){
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if(materialStack.size() > 0){
            System.out.print("Materials left: ");
            for (int i = 0; i < materialStack.size(); i++) {
                if(i == materialStack.size() - 1 ){
                    System.out.println(materialStack.pop());
                } else {
                    System.out.print(materialStack.pop() + ", ");
                    i--;
                }
            }
        }
        if(magicValuesQueue.size() > 0){
            System.out.print("Materials left: ");
            for (int i = 0; i < magicValuesQueue.size(); i++) {
                if(i == magicValuesQueue.size() -1){
                    System.out.println(magicValuesQueue.poll());
                } else {
                    System.out.print(magicValuesQueue.poll() + ", ");
                    i--;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : toys.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
