import java.util.Scanner;

public class PO2_Snake20Jun2020 {
    public static  int food = 0;
    public static int rowSnake = 0, colSnake = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];


        int[] firstBurrowIndexes = {-1, -1};
        int[] secondBurrowIndexes = {-1, -1};


        for (int r = 0; r < field.length; r++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                rowSnake = r;
                colSnake = line.indexOf("S");
            }
            fillBurrowIndexes(firstBurrowIndexes, secondBurrowIndexes, r, line);

            field[r] = line.toCharArray();
        }

        while (food < 10) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                //row - 1
                if(isOutOfBound(rowSnake -1,colSnake,field)){
                    break; 
                } else {
                    if(!moveSnake(rowSnake,colSnake,rowSnake -1,colSnake, field)) {
                        rowSnake--;
                    }
                }
            } else if (command.equals("down")) {
                //row + 1
                if(isOutOfBound(rowSnake + 1,colSnake,field)){
                    break;
                } else {
                    if(!moveSnake(rowSnake,colSnake,rowSnake +1,colSnake, field)) {
                        rowSnake++;
                    }
                }
            } else if (command.equals("left")) {
                // col -1
                if(isOutOfBound(rowSnake ,colSnake - 1,field)){
                    break;
                } else {
                    if(!moveSnake(rowSnake,colSnake,rowSnake ,colSnake -1, field)) {
                        colSnake--;
                    }
                }
            } else if (command.equals("right")) {
                // col +1
                if(isOutOfBound(rowSnake ,colSnake + 1,field)){
                    break;
                } else {
                    if(!moveSnake(rowSnake,colSnake,rowSnake ,colSnake +1, field)){
                        colSnake++;
                    }
                }
            }
        }
        if(food >= 10){
            System.out.println("You won! You fed the snake.");
        } else {
            field[rowSnake][colSnake] = '.';
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n",food);
        printFiled(field);
    }

    private static boolean moveSnake(int oldRow, int oldCol, int newRow, int newCol, char[][] field) {
          if(field[newRow][newCol] == '-'){
              field[newRow][newCol] = 'S';
          } else if(field[newRow][newCol] == '*'){
              field[newRow][newCol] = 'S';
              food ++;
          } else if(field[newRow][newCol] == 'B'){
             //which burrow is the snake at?
              // where is the other one?
              for (int row = 0; row < field.length; row++) {
                  for (int col = 0; col < field[row].length; col++) {
                      if(field[row][col] == 'B' && (row != newRow || col != newCol )){
                            field [row][col] = 'S';
                            field [newRow][newCol] = '.';
                            field [oldRow][oldCol] = '.';
                            rowSnake = row;
                            colSnake = col;
                            return true;
                      }
                  }
              }
          }
        field[oldRow][oldCol] = '.';
          return false;
    }

    private static boolean isOutOfBound(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

    // todo: this wont work if B's are at same row
    private static void fillBurrowIndexes(int[] firstBurrowIndexes, int[] secondBurrowIndexes, int r, String line) {
        if (line.contains("B")) {
            if (firstBurrowIndexes[0] == -1) {
                firstBurrowIndexes[0] = r;
                firstBurrowIndexes[1] = line.indexOf("B");
            } else {
                secondBurrowIndexes[0] = r;
                secondBurrowIndexes[1] = line.indexOf("B");
            }
        }
    }

    private static void printFiled(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
