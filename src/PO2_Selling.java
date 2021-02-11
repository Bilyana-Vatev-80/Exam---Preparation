import java.util.Scanner;

public class PO2_Selling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] position = new int [2];
        char[][] bakery = new char[size][size];
        for (int row= 0; row < size ; row++) {
            String line = scanner.nextLine();
            if(line.equals("S")){
                bakery[position[0]][position[1]] = "S";
            }
        }
    }
}
