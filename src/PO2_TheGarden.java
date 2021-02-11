import java.util.Scanner;

public class PO2_TheGarden {
    public static int carrots = 0;
    public static int potatoes = 0;
    public static int lettuce = 0;
    public static int harmedVegetables = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rows][];

        for (int row = 0; row < rows; row++) {
            field [row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        String input = "";
        while (!"End of Harvest".equals(input = scanner.nextLine())){

            if(input.contains("Harvest") ){
                int row = Integer.parseInt(input.split(" ")[1]);
                int col = Integer.parseInt(input.split(" ")[2]);
                if(!isOutOfBound(field,row,col)){
                    harvest(row,col,field);
                }
            } else {
                int row = Integer.parseInt(input.split(" ")[1]);
                int col = Integer.parseInt(input.split(" ")[2]);
                String direction = input.split(" ")[3];
                if(!isOutOfBound(field,row,col)){
                    moleMovement(row,col,direction,field);
                }
            }
        }

        printTheMatrix(field);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);
    }

    private static void moleMovement(int row, int col, String direction, char[][] field) {
        if(direction.equals("up")){
            for (int i = row; i >= 0 ; i -= 2) {
                if(field[i][col] != ' '){
                    field[i][col] = ' ';
                    harmedVegetables ++;
                }
            }
        } else if (direction.equals("down")){
            for (int i = row; i < field.length; i+= 2) {
                if(field[i][col] != ' '){
                    field[i][col] = ' ';
                    harmedVegetables ++;
                }
            }
        } else if (direction.equals("right")){
            for (int i = col; i < field[row].length; i += 2) {
                if(field[row][i] != ' '){
                    field[row][i] = ' ';
                    harmedVegetables ++;
                }
            }
        }else if (direction.equals("left")){
            for (int i = col; i >= 0 ; i -= 2) {
                if(field[row][i] != ' '){
                    field[row][i] = ' ';
                    harmedVegetables ++;
                }
            }
        }
    }

    private static void harvest(int row, int col, char[][] field) {
        if(field[row][col] == 'L'){
            lettuce++;
            field[row][col] = ' ';
        } else if (field[row][col] == 'P'){
            potatoes ++;
            field[row][col] = ' ';
        } else if(field[row][col] == 'C'){
            carrots ++;
            field[row][col] = ' ';
        }
    }

    private static boolean isOutOfBound(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
